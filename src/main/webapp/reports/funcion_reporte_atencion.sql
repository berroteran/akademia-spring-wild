-- 	drop function fn_etiqueta_atencion(int, int);
--	select * from fn_etiqueta_atencion(33);
CREATE OR REPLACE FUNCTION fn_etiqueta_atencion(pId int)
RETURNS TABLE(
	atencion varchar
	, nombre varchar
	, codigo_oficina varchar 
	, nombre_oficina varchar
	, nombre_producto varchar
	, codigo_producto varchar
	, humedad numeric
	, impureza numeric	
	, anio int
	, codigo_barra text
	, impresiones int
	, peso_total numeric
	, peso_neto numeric
) AS $$
begin
	
		
	RETURN QUERY 	
	with temporal as (
	SELECT 
		a.id
		, a.no_atencion as atencion_i
		,  case 
			when p.persona_natural is true then
				regexp_replace(trim(p.primer_nombre), '[^\w]+',' ') 
				|| case when p.segundo_nombre is not null then regexp_replace(trim(p.segundo_nombre), '[^\w]+',' ') || ' ' else '' end
				|| case when p.primer_apellido is not null then regexp_replace(trim(p.primer_apellido), '[^\w]+',' ') || ' ' else '' end
				|| case when p.segundo_apellido is not null then regexp_replace(trim(p.segundo_apellido), '[^\w]+',' ') || ' ' else '' end
			else 
				p.nombre_comercial 
			end as nombre_i
		, ofi.codigo codigo_oficina_i
		, ofi.nombre nombre_oficina_i
		, pr.codigo codigo_producto_i
		, pr.nombre nombre_producto_i
		, coalesce(a.peso_total,0) as peso_i
		, coalesce(a.impureza,0) impureza_i
		, coalesce(a.humedad,0) humedad_i
		, cast(EXTRACT(YEAR FROM a.fecha_compra) as int) anio_i
		, coalesce(ofi.codigo,'0') 
			|| coalesce(pr.codigo,'0') 
			|| EXTRACT(YEAR FROM a.fecha_creacion) 
			|| cast(coalesce(a.humedad,0)*100 as int) 
			|| cast(coalesce(a.impureza ,0)*10 as int) 
			|| coalesce(a.no_atencion,'0') as codigo_barra_i
		, coalesce(a.etiqueta_impresiones,0) impresiones_i
		, coalesce(a.peso_total,0) peso_total_i
		, cast(coalesce(a.peso_total,0) - (coalesce(a.envase_cantidad,0)  * coalesce(en.peso,0)) as numeric) peso_neto_i
	FROM atencion a
		inner join proveedor p 
			on p.id = a.proveedor_id
		inner join producto pr
			on pr.id = a.producto_id
		inner join oficina ofi
			on ofi.id = a.oficina_id
		left join envase en
			on en.id = a.envase_id 
	where	a.id = pId   
	)
	select	atencion_i
			, nombre_i 
			, codigo_oficina_i
			, nombre_oficina_i
			, nombre_producto_i
			, codigo_producto_i
			, humedad_i
			, impureza_i
			, anio_i
			, codigo_barra_i
			, impresiones_i
			, peso_total_i
			, peso_neto_i
	from	temporal;

END;
$$ LANGUAGE plpgsql

--	select * from fn_etiqueta_atencion(33);
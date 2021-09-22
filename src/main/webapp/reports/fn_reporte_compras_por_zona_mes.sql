-- 	drop function fn_compras_por_zona_mes(varchar,varchar,date,date,varchar,varchar,varchar);
--	select * from fn_compras_por_zona_mes('0','0',null,null,'0','0','0');
CREATE OR REPLACE FUNCTION fn_compras_por_zona_mes(
	pZonas varchar
	, pSucursales varchar
	, pFechaIni date
	, pFechaFin date
	, pProveedor varchar
	, pProducto varchar
	, pDocumento varchar
)
RETURNS TABLE(
	id int
	, zona varchar
	, producto varchar
	, precio numeric
	, tn numeric
	, kn numeric
	, monto numeric
	, fob numeric
) AS $$
begin
	return QUERY	

	with zona as (
		SELECT 	o.id
				, o.codigo
				, o.nombre
				, o.sede
				, o.zona
		from	oficina o
		where	o.activo = true
	)
	, productos as (
		select 	p.id
				, p.codigo
				, p.nombre
				-- select *
		from	producto p
		limit	3
	)
	, proveedores as (
		select 	pr.id 
				, pr.nombre_comercial 
		from	proveedor pr
		where	pr.activo = true
		limit 	1
	)
	, documentos as (
	
		select 	dc.id 
				, dc.numero_documento 
				, dc.serie_documento 
				, dc.tipo_documento_id 
				, tdc.descripcion 
		from	documento_compra dc
				inner join tipo_documento tdc
					on tdc.id = dc.tipo_documento_id 
		limit 	1
		
	)	
	, tmp as (
		select	cast(233560 as numeric) as precio_s
				, cast(6.8 as numeric) as tn_s
				, cast(2264 as numeric) as kn_s
				, cast(4458 as numeric) as monto_s
				, cast(1234 as numeric) as fob_s
	)
	select	cast(c.id as int) id
			, cast(substring(a.sede,1,2) || '-' || a.sede as varchar) as zona_
			, cast(c.codigo || ' - ' || c.nombre as varchar) prod
			, b.*
	from	zona a
			inner join productos c
				on 1=1
			inner join tmp b
				on 1=1;

END;
$$ LANGUAGE plpgsql

--	select * from fn_compras_por_zona_mes('0','0',null,null,'0','0','0') order by id;
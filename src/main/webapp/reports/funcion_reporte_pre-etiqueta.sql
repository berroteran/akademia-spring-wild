-- 	drop function fn_pre_etiqueta(int, int);
--	select * from fn_pre_etiqueta(33,10);
CREATE OR REPLACE FUNCTION fn_pre_etiqueta(pId int, pNums int)
RETURNS TABLE(
	nrow bigint
	, ntrow bigint
	, id bigint 
	, atencion varchar
	, nombre varchar
	, codigo varchar
	, peso_total numeric
	, peso numeric
	, humedad numeric
	, impureza numeric) AS $$
begin
	
    RETURN QUERY 
	with temporal_pesos as (
	select	row_number() over (order by (z.num_serie)) as indice
			, cast(a.id as bigint) oid
			, a.no_atencion as oatencion
			,  case 
				when p.persona_natural is true then
					regexp_replace(trim(p.primer_nombre), '[^\w]+',' ') 
					|| case when p.segundo_nombre is not null then regexp_replace(trim(p.segundo_nombre), '[^\w]+',' ') || ' ' else '' end
					|| case when p.primer_apellido is not null then regexp_replace(trim(p.primer_apellido), '[^\w]+',' ') || ' ' else '' end
					|| case when p.segundo_apellido is not null then regexp_replace(trim(p.segundo_apellido), '[^\w]+',' ') || ' ' else '' end
							else 
								p.nombre_comercial 
							end as onombre
			, pr.codigo ocodigo
			, cast(coalesce(a.peso_total,0)-(coalesce(a.envase_cantidad,0)  * coalesce(en.peso,0))as numeric) opeso_total
			, cast(coalesce(a.peso_total,0)-(coalesce(a.envase_cantidad,0)  * coalesce(en.peso,0))as numeric) opeso
			, coalesce(a.humedad ,0) ohumedad
			, coalesce(a.impureza,0) oimpureza
	FROM 	atencion a
			inner join proveedor p 
				on p.id = a.proveedor_id
			inner join producto pr
				on pr.id = a.producto_id
			inner join (
					select 	num_serie 
					from 	generate_series(1, case when coalesce(pNums,0) = 0 then 1 else pNums end) as num_serie
			) z on 1=1				
			left join envase en
				on en.id = a.envase_id 		
	where	a.id =  pId
    )
    select 	a.indice
    		, b.total_row
			, a.oid
			, a.oatencion
			, a.onombre
			, a.ocodigo
			, a.opeso_total
			, a.opeso
			, a.ohumedad
			, a.oimpureza
    from 	temporal_pesos a
    		inner join (
    			select 	max(indice) total_row
    			from 	temporal_pesos
    		) b on 1=1;
   
    
END;
$$ LANGUAGE plpgsql


--	select * from fn_pre_etiqueta(33,10);
-- 	drop function fn_fob_resumen_diario();
--	select * from fn_fob_resumen_diario();
CREATE OR REPLACE FUNCTION fn_fob_resumen_diario()
RETURNS TABLE(
	id int
	, zona varchar
	, producto varchar
	, st_kn numeric
	, st_pcompra numeric
	, st_ppromedio numeric
	, st_fob numeric
	, tr_kn numeric
	, tr_pcompra numeric
	, tr_ppromedio numeric
	, tr_fob numeric
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
				, p.nombre
		from	producto p
		where 	p.id = 3
	)
	, tmp as (
		select	cast(34351 as numeric) as kn
				, cast(233560 as numeric) as pc
				, cast(6.8 as numeric) as pp
				, cast(2264 as numeric) as fob
	)
	select	cast(a.id as int)
			, a.zona
			, c.nombre
			, cast(b.kn as numeric) as st_kn_
			, cast(b.pc as numeric) st_pcompra_
			, cast(b.pp as numeric) st_ppromedio_
			, cast(b.fob as numeric) st_fob_
			, cast(b.kn/10 as numeric) tr_kn_
			, cast(b.pc/10 as numeric) tr_pcompra_
			, cast(b.pp/10 as numeric) tr_ppromedio_
			, cast(b.fob/10 as numeric) tr_fob_
	from	zona a
			inner join productos c
				on 1=1
			inner join tmp b
				on 1=1;

END;
$$ LANGUAGE plpgsql

--	select * from fn_fob_resumen_diario();
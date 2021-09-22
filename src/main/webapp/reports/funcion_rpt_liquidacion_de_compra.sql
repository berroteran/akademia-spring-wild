select 	
		c.id 
		, c.fecha_compra 
		, c.fecha_liquidacion
		, c.moneda_id
--compra-----------------------------------------------------------
		, p.dni
		, case 
			when p.persona_natural = true 
			then p.primer_nombre
				|| case 
					when coalesce(p.segundo_nombre,'') != ''
					then ' ' || p.segundo_nombre else '' end
				|| ' ' || p.primer_apellido
				|| case 
					when coalesce(p.segundo_apellido,'') != ''
					then ' ' || p.segundo_apellido else '' end
			else 
				p.razonsocial end as nombre_proveedor
		, upper('**preguntar**') as tipo_de_direccion
		, upper(p.direccion ) as direccion
		, upper('**preguntar**') as datos_referencia
--proveedor-----------------------------------------------------------
		, cast(5 as int) as cantidad_sacos_yute
		, cast(0 as int) as cantidad_sacos_plastico
		, mnd.signo 
		, case when mnd.descripcion ='SOL' then 'SOLES' 
				when mnd.descripcion ='USD' then 'DOLARES'
				else 'UNKNOW' end moneda
		, ct.licencia as licencia_tra
		, ct.marca as marca_tra
		, ct.placa as placa_tra
		, upper('**preguntar**') as tipo_de_direccion_tra
		, upper('**preguntar**') as lugar_direccion_tra
		, upper('**preguntar**') as datos_referenciales_tra
		, upper('**preguntar**') as punto_de_llegada_tra
--datos operacion y transporte-------------------------------------------		
		, pro.codigo as codigo_prod
		, pro.nombre as nombre_prod
		, a.peso_total as peso_bruto
		, a.tara 
		, a.peso_neto
		, cai.valor_unitario 
		, cai.tipo_afectacion_igv 
		, cai.monto_igv 
		, cai.tipo_afectacion_ir 
		, cai.monto_ir 
		, a.humedad 
		, a.impureza 
		, cai.importe_total_neto_operacion 
		, fu_numero_letras(cai.importe_total_neto_operacion::numeric) as importe_total_letras
from 	compra c
		left join moneda mnd
			on mnd.id = c.moneda_id 
		left join compra_transporte ct 
			on ct.compra_id = c.id 
		left join proveedor p
			on p.id = c.proveedor_id 
		left join compra_atencion_importe cai 
			on cai.compra_id  = c.id
		left join atencion a
			on a.id = cai.atencion_id 
		left join producto pro
			on pro.id = a.producto_id 
where c.id = 28
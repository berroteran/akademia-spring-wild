select	rem.fecha_emision 
		, rem.fecha_traslado 
		, guia.numero_guia_remision 
		, guia.peso_bruto
		, guia.tara 
		, guia.peso_neto 
		, origen.direccion as dir_origen
		, destino.direccion as dir_destino
		, tp2.razon_social 
		, tp2.ruc 
		, tp2.tipo_transporte
		, tc.no_licencia_conducir
		, tc.nombre_completo
		, tu.numero_cert_inscripcion
		, tu.marca
		, tu.placa
		, aux.*
		, tmp.*
from	remesa_guia_remision guia
		inner join remesa rem 
			on rem.id = guia.remesa_id 
		left join oficina origen
			on origen.id = rem.oficina_origen_id 
		left join oficina destino
			on destino.id = rem.oficina_destino_id 
		left join transporte_proveedor tp2 
			on tp2.id = rem.transporte_proveedor_id 
		left join transporte_chofer tc 
			on tc.id = rem.transporte_chofer_id 
		left join transporte_unidad tu 
			on tu.id  = rem.transporte_unidad_id 
		left join lateral (
			
				select	string_agg(t.codigosap,'/') as codigosap
						, string_agg(t.nombre,'/') as nombre
						, string_agg(t.norma,'/') as norma
						, t.descripcion
						, sum(t.sacos) as sacos
				from	(
		
							select	pr.codigosap as codigosap 
									, pr.nombre 
									, pr.norma
									, e.descripcion 
									, count(pld.id) as sacos
							from	remesa_guia_remision_detalle det
									inner join packing_list pl  
										on pl.id = det.packing_list_id 
									left join packing_list_detalle pld 
										on pld.packing_id = pl.id 
									left join producto pr
										on pr.id = pl.producto_id 
									left join envase e 
										on e.id = pl.envase_id 	
							where 	det.remesa_guia_remision_id = guia.id
							group	by 
									pr.codigosap 
									, pr.nombre 
									, pr.norma
									, e.descripcion 
						) t
				group	by
						t.descripcion
					
		) aux on 1=1
		left join lateral (
		
			select	string_agg(tp.numero, '-') precintos
			from	transporte_precinto tp 
			where	tp.remesa_id = guia.remesa_id
					and tp.transporte_unidad_id = rem.transporte_unidad_id
		
		) tmp on 1=1
where	guia.id = 5351
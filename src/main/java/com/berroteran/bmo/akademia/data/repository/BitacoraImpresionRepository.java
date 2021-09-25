package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.BitacoraImpresion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BitacoraImpresionRepository  extends CrudRepository<BitacoraImpresion, Integer> {

    @Query("select b from BitacoraImpresion b where b.reporte = :pReporte and b.documento = :pDocumento")
    List<BitacoraImpresion> getByReporteAndDocument(@Param("pReporte") String reporte, @Param("pDocumento") String documento);
}

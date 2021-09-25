package com.berroteran.bmo.akademia.service.catalogo;

import com.berroteran.bmo.akademia.model.BitacoraImpresion;

import java.util.List;

public interface BitacoraImpresionService {


    void save(BitacoraImpresion obj);

    List<BitacoraImpresion> getByReporte(String reporte, String documento);

}

package com.machupichu.zonas.service.catalogo;

import com.machupichu.zonas.model.BitacoraImpresion;

import java.util.List;

public interface BitacoraImpresionService {


    void save(BitacoraImpresion obj);

    List<BitacoraImpresion> getByReporte(String reporte, String documento);

}

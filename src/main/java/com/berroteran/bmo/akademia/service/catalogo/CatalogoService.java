package com.berroteran.bmo.akademia.service.catalogo;

import com.berroteran.bmo.akademia.model.Catalogo;

import java.util.List;

public interface CatalogoService {
    List<Catalogo> findByCatalogoPadre(Long catalogoPadre);

    Catalogo findByCode(String code);
}

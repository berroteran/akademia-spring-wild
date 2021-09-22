package com.machupichu.zonas.service.catalogo;

import com.machupichu.zonas.model.Catalogo;

import java.util.List;

public interface CatalogoService {
    List<Catalogo> findByCatalogoPadre(Long catalogoPadre);

    Catalogo findByCode(String code);
}

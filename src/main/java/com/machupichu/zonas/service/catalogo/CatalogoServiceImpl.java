package com.machupichu.zonas.service.catalogo;

import com.machupichu.zonas.data.repository.CatalogoRepository;
import com.machupichu.zonas.model.Catalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    @Autowired
    private CatalogoRepository catalogoRepository;

    @Transactional
    @Override
    public List<Catalogo> findByCatalogoPadre(Long catalogoPadreId) {
        return catalogoRepository.findByCatalogoId(catalogoPadreId);
    }

    @Transactional
    @Override
    public Catalogo findByCode(String code) {
        return catalogoRepository.findByCodigo(code);
    }


}

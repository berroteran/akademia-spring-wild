package com.machupichu.zonas.service.catalogo;

import com.machupichu.zonas.data.repository.BitacoraImpresionRepository;
import com.machupichu.zonas.model.BitacoraImpresion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BitacoraImpresionServiceImpl implements BitacoraImpresionService {

    @Autowired
    BitacoraImpresionRepository repository;

    @Transactional
    @Override
    public void save(BitacoraImpresion obj) {
        repository.save(obj);
    }

    @Override
    public List<BitacoraImpresion> getByReporte(String reporte, String documento) {
        return repository.getByReporteAndDocument(reporte, documento);
    }
}

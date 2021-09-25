package com.berroteran.bmo.akademia.service.catalogo;

import com.berroteran.bmo.akademia.data.repository.BitacoraImpresionRepository;
import com.berroteran.bmo.akademia.model.BitacoraImpresion;
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

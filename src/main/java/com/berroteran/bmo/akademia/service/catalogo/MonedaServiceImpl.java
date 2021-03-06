package com.berroteran.bmo.akademia.service.catalogo;

import com.berroteran.bmo.akademia.data.repository.MonedaRepository;
import com.berroteran.bmo.akademia.model.Moneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MonedaServiceImpl implements MonedaService{

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    public List<Moneda> listarMonedas() {
        Iterable<Moneda> iterable = monedaRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }
}

package com.berroteran.bmo.akademia.service;

import com.berroteran.bmo.akademia.data.repository.AlumnoRepository;
import com.berroteran.bmo.akademia.data.repository.MateriaRepository;
import com.berroteran.bmo.akademia.data.repository.OficinaRepository;
import com.berroteran.bmo.akademia.model.Cliente;
import com.berroteran.bmo.akademia.model.Materia;
import com.berroteran.bmo.akademia.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AlumnoServicio {

    private static final Logger LOGGER = Logger.getLogger(AlumnoServicio.class.getName());

    @Autowired
    private AlumnoRepository alumnoRepository;


    public Iterable<Cliente> findAll() {
        return alumnoRepository.findAll();
    }


}

package com.berroteran.bmo.akademia.service;

import com.berroteran.bmo.akademia.data.repository.CursoRepository;
import com.berroteran.bmo.akademia.data.repository.HorarioRepository;
import com.berroteran.bmo.akademia.data.repository.OficinaRepository;
import com.berroteran.bmo.akademia.model.Horario;
import com.berroteran.bmo.akademia.model.Materia;
import com.berroteran.bmo.akademia.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class HorariosServicio {

    private static final Logger LOGGER = Logger.getLogger(HorariosServicio.class.getName());

    @Autowired
    private OficinaRepository oficinaRepositorio;

    @Autowired
    private HorarioRepository horarioRepository;


    public Iterable<Horario> findAll() {
     return   horarioRepository.findAll();
    }


    @Transactional
    public void guardarHorario(Horario horario) throws BusinessException {

        horarioRepository.save( horario );

    }
}

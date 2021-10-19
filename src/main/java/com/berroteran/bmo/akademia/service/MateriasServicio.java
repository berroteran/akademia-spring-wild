package com.berroteran.bmo.akademia.service;

import com.berroteran.bmo.akademia.data.repository.MateriaRepository;
import com.berroteran.bmo.akademia.data.repository.OficinaRepository;
import com.berroteran.bmo.akademia.model.Materia;
import com.berroteran.bmo.akademia.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MateriasServicio {

    private static final Logger LOGGER = Logger.getLogger(MateriasServicio.class.getName());

    @Autowired
    private OficinaRepository oficinaRepositorio;

    @Autowired
    private MateriasServicio materiasServicio;

    @Autowired
    private MateriaRepository materiaRepository;

    public Iterable<Materia> findAll() {
        return materiaRepository.findAll();
    }

    public Materia guardarMateria(Materia materia) throws BusinessException {
            if ( materia == null )
                throw new BusinessException("No ha definido la materia a guardar");

            return materiaRepository.save( materia );
    }
}

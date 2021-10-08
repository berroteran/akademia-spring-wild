package com.berroteran.bmo.akademia.service;

import com.berroteran.bmo.akademia.data.repository.CursoRepository;
import com.berroteran.bmo.akademia.data.repository.OficinaRepository;
import com.berroteran.bmo.akademia.model.Curso;
import com.berroteran.bmo.akademia.model.Oficina;
import com.berroteran.bmo.akademia.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CursoServicio {

    private static final Logger LOGGER = Logger.getLogger(CursoServicio.class.getName());

    @Autowired
    private OficinaRepository oficinaRepositorio;
    @Autowired
    private CursoRepository cursoRepository;

    public Iterable<Curso> findAll() {
        return cursoRepository.findAll();
    }


    public long count() {
        return cursoRepository.count();
    }

    public void delete(Curso curso) {
        cursoRepository.delete(curso);
    }


    @Transactional
    public void guardarCurso(Curso curso) throws BusinessException {
        if ( curso == null) {
            LOGGER.log(Level.SEVERE, "La Oficina esta nulo. ¿Está seguro que está bien escrito?");
            throw new BusinessException("La Oficina esta nulo. ¿Está seguro que está bien escrito?");

        }
        cursoRepository.save(curso);
    }


    public List<Curso> getAllActivos() {
        return cursoRepository.getAllActivos();
    }
}

package com.berroteran.bmo.akademia.service;

import com.berroteran.bmo.akademia.data.repository.MatriculaRepository;
import com.berroteran.bmo.akademia.data.repository.OficinaRepository;
import com.berroteran.bmo.akademia.model.Matricula;
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
public class MatriculaServicio {

    private static final Logger LOGGER = Logger.getLogger(MatriculaServicio.class.getName());

    @Autowired
    private OficinaRepository OficinaRepositorio;

    @Autowired
    private MatriculaRepository matriculaRepository;


    public Iterable<Matricula> findAll() {
        return matriculaRepository.findAll();
    }


    public Collection<Oficina> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return (Collection<Oficina>) OficinaRepositorio.findAll();
        } else {
            return OficinaRepositorio.search(stringFilter);
        }
    }

    public long count() {
        return OficinaRepositorio.count();
    }

    public void delete(Oficina Oficina) {
        OficinaRepositorio.delete(Oficina);
    }


    @Transactional
    public void save(Matricula matricula) throws BusinessException {
        if (matricula == null) {

            LOGGER.log(Level.SEVERE, "La Oficina esta nulo. ¿Está seguro que está bien escrito?");
            throw new BusinessException("La Oficina esta nulo. ¿Está seguro que está bien escrito?");

        }
        matriculaRepository.save( matricula );
    }


    public List<Matricula> getAllActiva() {
        //return matriculaRepository.getAllActivos();
        return null;
    }

}

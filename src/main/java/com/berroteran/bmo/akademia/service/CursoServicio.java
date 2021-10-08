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

    public Iterable<Oficina> findAll() {
        return oficinaRepositorio.findAll();
    }

    public Collection<Oficina> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return (Collection<Oficina>) oficinaRepositorio.findAll();
        } else {
            return oficinaRepositorio.search(stringFilter);
        }
    }

    public long count() {
        return oficinaRepositorio.count();
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


    public Map<String, Integer> getStats() {
        HashMap<String, Integer> stats = new HashMap<>();
        findAll().forEach(Oficina -> stats.put(Oficina.getCodigo(), 1));
        return stats;
    }

    public List<Oficina> getAllActiva() {
        return oficinaRepositorio.getAllActivos();
    }
}

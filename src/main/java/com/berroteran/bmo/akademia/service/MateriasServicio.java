package com.berroteran.bmo.akademia.service;

import com.berroteran.bmo.akademia.data.repository.MateriaRepository;
import com.berroteran.bmo.akademia.data.repository.OficinaRepository;
import com.berroteran.bmo.akademia.model.Materia;
import com.berroteran.bmo.akademia.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
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


    public <S extends Materia> S save(S entity) {
        return null;
    }

    public <S extends Materia> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    public Materia findById(Materia materia) {
        return materiaRepository.findById( materia.getId() ).get();
    }

    public boolean existsById(Integer integer) {
        return false;
    }

    public Iterable<Materia> findAll() {
        return materiaRepository.findAll();
    }

    public Iterable<Materia> findAllById(Iterable<Integer> integers) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Integer integer) {

    }

    public void delete(Materia entity) {

    }

    public void deleteAll(Iterable<? extends Materia> entities) {

    }

    public void deleteAll() {

    }

    public Materia guardarMateria(Materia materia) throws BusinessException {
            if ( materia == null )
                throw new BusinessException("No ha definido la materia a guardar");

            return materiaRepository.save( materia );
    }


}

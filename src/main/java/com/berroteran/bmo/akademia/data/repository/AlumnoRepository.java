package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Curso, Integer> {

}

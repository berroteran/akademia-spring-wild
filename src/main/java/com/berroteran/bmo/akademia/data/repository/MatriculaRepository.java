package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.Matricula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, Integer> {


}

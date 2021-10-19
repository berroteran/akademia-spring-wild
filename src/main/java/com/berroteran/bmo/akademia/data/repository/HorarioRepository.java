package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.Horario;
import com.berroteran.bmo.akademia.model.Matricula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HorarioRepository extends CrudRepository<Horario, Integer> {


}

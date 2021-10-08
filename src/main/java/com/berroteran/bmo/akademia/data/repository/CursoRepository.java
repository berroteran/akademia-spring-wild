package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.Curso;
import com.berroteran.bmo.akademia.model.Oficina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer> {

    @Query("select c from Curso c where c.activo = true")
    List<Curso> getAllActivos();

}

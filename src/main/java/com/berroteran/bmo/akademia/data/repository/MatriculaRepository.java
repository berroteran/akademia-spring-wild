package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.Matricula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, Integer> {

    @Query("select m from Matricula m join fetch m.curso c join fetch m.sucursal s join fetch m.alumno a join fetch c.materia mat join fetch c.horario " + "where m.activo = true order by m.id desc")
    Iterable<Matricula> getAllDataActivas();

}

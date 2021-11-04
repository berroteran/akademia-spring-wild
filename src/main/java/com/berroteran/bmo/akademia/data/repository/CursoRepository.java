package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.Curso;
import com.berroteran.bmo.akademia.model.Materia;
import com.berroteran.bmo.akademia.model.Oficina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer> {

    @Query("select c from Curso c join fetch c.sucursal join fetch c.horario join fetch c.materia where c.activo = true ")
    Iterable<Curso> findAllActivos();

    @Query("select c from Curso c join fetch c.sucursal join fetch c.horario join fetch c.materia")
    Iterable<Curso> findAllFetch();


    @Query("select c from Curso c join fetch c.materia join fetch c.horario where c.activo=true and c.sucursal = :sucursal")
    List<Curso> getActivosBySucursal(Oficina sucursal);
}

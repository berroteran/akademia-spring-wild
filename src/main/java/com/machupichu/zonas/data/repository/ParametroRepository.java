package com.machupichu.zonas.data.repository;

import com.machupichu.zonas.model.Parametro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepository extends CrudRepository<Parametro, Integer> {

    @Query("select p from Parametro p where p.clave = :pClave")
    Parametro findByClave(@Param("pClave") String pClave);

    @Query("select p.valor from Parametro  p where p.clave = :parametroClave ")
    String getValue(String parametroClave);
}

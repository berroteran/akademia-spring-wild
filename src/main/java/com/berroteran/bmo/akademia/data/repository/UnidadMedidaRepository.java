package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.UnidadMedida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadMedidaRepository extends CrudRepository<UnidadMedida, Long> {
    @Query("select e from UnidadMedida e " +
            "where lower(e.nombre) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(e.abreviatura) like lower(concat('%', :searchTerm, '%'))")
    List<UnidadMedida> search(@Param("searchTerm") String searchTerm);
}
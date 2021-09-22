package com.machupichu.zonas.data.repository;

import com.machupichu.zonas.model.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Long> {

    @Query("select r from Roles r")
    List<Roles> search();
}

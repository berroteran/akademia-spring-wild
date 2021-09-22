package com.machupichu.zonas.data.repository;

import com.machupichu.zonas.model.Moneda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends CrudRepository<Moneda, Integer> {

}

package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.Moneda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends CrudRepository<Moneda, Integer> {

}

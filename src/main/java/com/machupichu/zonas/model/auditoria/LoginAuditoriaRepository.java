package com.machupichu.zonas.model.auditoria;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginAuditoriaRepository extends CrudRepository<LoginAuditoria,Integer> {



}

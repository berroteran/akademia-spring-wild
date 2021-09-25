package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.ConfiguracionEmail;
import com.berroteran.bmo.akademia.model.EventosEnum;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConfiguracionEmailRepository extends CrudRepository<ConfiguracionEmail, Long> {

    ConfiguracionEmail findByEvento(EventosEnum eventosEnum);

    List<ConfiguracionEmail> findAll();

    @Modifying(clearAutomatically = true)
    @Query("update ConfiguracionEmail config set config.servidor=:servidor, config.puerto=:puerto, " +
            "config.cuenta=:cuenta,config.clave=:clave")
    void actualizarConfiguracion(@Param("servidor") String servidor,
                                 @Param("puerto") Integer puerto,
                                 @Param("cuenta") String cuenta,
                                 @Param("clave") String clave);
}

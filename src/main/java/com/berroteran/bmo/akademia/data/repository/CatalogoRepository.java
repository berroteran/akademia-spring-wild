package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.Catalogo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoRepository extends CrudRepository<Catalogo, Long> {
    /**
     * Obtener la lista de catalogos por id de catalogo padre.
     * @return
     */
    List findByCatalogoId(Long catalogoPadreId);

    /**
     * Obtiene el catalogo por medio de su codigo
     * @param code
     * @return
     */
    Catalogo findByCodigo(String code);
}

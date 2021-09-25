package com.berroteran.bmo.akademia.data.repository;

import com.berroteran.bmo.akademia.model.Oficina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OficinaRepository extends CrudRepository<Oficina, Integer> {

    @Query("select e from Oficina e " + "where lower(e.zona) like lower(concat('%', :searchTerm, '%')) " + "or lower(e.nombre) like lower(concat('%', :searchTerm, '%'))" + " order by e.centroSap desc")
    List<Oficina> search(@Param("searchTerm") String searchTerm);

    List<Oficina> findAllByActivoIsTrue();

    List<Oficina> findAllByActivoIsTrueOrderByCentroSapAsc();

    @Query("select o from Oficina o where o.activo = true")
    List<Oficina> getAllActivos();

    @Query("select o.noReporteProductionTrans from Oficina o where o.id=:id")
    Integer getInformeConsecutivo(@Param("id") Integer id);

    @Query("update Oficina o set o.noReporteProductionTrans =:contador where o.id=:idOficina")
    void setInformeConsecutivoPlus(@Param("contador") Integer contador, @Param("idOficina") Integer idOficina);

}

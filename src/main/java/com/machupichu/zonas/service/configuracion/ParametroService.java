package com.machupichu.zonas.service.configuracion;

import com.machupichu.zonas.model.Parametro;
import com.machupichu.zonas.utils.BusinessException;

import java.util.List;

public interface ParametroService {

    List<Parametro> findAll();

    Parametro getById(Integer pId);

    Parametro getByClave(String pClave);

    Iterable<Parametro> getAllParameters();

    void saveParametro(String parametro, String valor);

    String getValueByClave(String parametroClave) throws BusinessException;

    String getValueByClave(String parametroClave, String valorDefecto) throws BusinessException;
}

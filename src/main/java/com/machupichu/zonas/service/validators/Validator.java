package com.machupichu.zonas.service.validators;

import com.machupichu.zonas.utils.BusinessException;

public interface Validator<T extends Entidad> {

    void validar(T param) throws BusinessException;
}

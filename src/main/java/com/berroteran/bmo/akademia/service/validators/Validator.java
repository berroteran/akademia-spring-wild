package com.berroteran.bmo.akademia.service.validators;

import com.berroteran.bmo.akademia.utils.BusinessException;

public interface Validator<T extends Entidad> {

    void validar(T param) throws BusinessException;
}

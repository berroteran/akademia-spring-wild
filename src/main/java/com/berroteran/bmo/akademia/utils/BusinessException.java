package com.berroteran.bmo.akademia.utils;


//Clase utilitaria para manejar los errores de negocio.
public class BusinessException extends Exception{

    public BusinessException(String s) {
        super( s);
    }

    public BusinessException(String s, Throwable throwable) {
        super(s, throwable);
    }
}

package com.machupichu.zonas.view.utils;

import java.util.Arrays;

public enum ProcesoCompraEnum {

    TRASEGADO(1, "Trasegado")
    , TRANSFORMADO(2,"Transformado")
    , REMESADO(3, "Remesado")
    , ORD_PROD_PROCESADA(4,"Ord. Prod. Procesada");

    private int id;
    private String descripcion;

    ProcesoCompraEnum(int id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }

    public static ProcesoCompraEnum getById(int id){

        for(ProcesoCompraEnum e : values()) {
            if(e.id == id ) return e;
        }

        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static boolean permiteAnular(int id){
        return !Arrays.asList(1,2,3,4).contains(id);
    }
}

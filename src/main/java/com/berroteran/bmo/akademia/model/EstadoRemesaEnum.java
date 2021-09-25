package com.berroteran.bmo.akademia.model;

public enum EstadoRemesaEnum {

    ANULADO(0, "Anulado")
    , EN_CURSO(1, "En curso")
    , PENDIENTE(2, "Pendiente")
    , RECEPCION_PARCIAL(3, "Recepcion parcial")
    , RECEPCIONADO(4, "Recepcionado");



    private Integer id;
    private String descripcion;

    EstadoRemesaEnum(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public static EstadoRemesaEnum getById(Integer id) {
        for (EstadoRemesaEnum e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }

        return null;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

package com.berroteran.bmo.akademia.model;

public enum TipoIR {

    NO_GRAVADO(0, "No grabado")
    , GRAVADO(1,"Grabado");

    private int id;
    private String descripcion;

    TipoIR(int id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }

    public TipoIR getById(int id){

        for(TipoIR e : values()) {
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
}

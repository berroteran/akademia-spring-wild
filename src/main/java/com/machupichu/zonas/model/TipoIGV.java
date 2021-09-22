package com.machupichu.zonas.model;

public enum TipoIGV {

    EXONERADO(0, "Exonerado")
    , GRAVADO(1,"Grabado")
    , INAFECTO(2,"Inafecto");

    private int id;
    private String descripcion;

    TipoIGV(int id, String descripcion){
        this.id = id;
        this.descripcion =descripcion;
    }

    public TipoIGV getById(int id){

        for(TipoIGV e : values()) {
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

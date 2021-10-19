package com.berroteran.bmo.akademia.model;

public enum CursoNivelEnum {

    ANULADO(0, "No definido"),
    PRINCIPIANTE(1, "Principiante"),
    INTERMEDIO(2, "Intermedio"),
    AVANZADO(3, "Avanzado"),
    ;



    private Integer id;
    private String descripcion;

    CursoNivelEnum(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public static CursoNivelEnum getById(Integer id) {
        for (CursoNivelEnum e : values()) {
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

package com.berroteran.bmo.akademia.model;

public enum EstadosProcesoEnum {
    ANULADO(0, "ANULADO"),
    ATENCION(1, "Atencion"),
    COMPRADO(2, "Comprado"),
    TRANSFORMADO(3, "Transformado"),
    TRASEGADO(4, "Trasegado"),
    PACKING(5, "Packing"),
    REMESADO(6, "Remesado"),
    REMESA_RECIBIDA(7, "Recibido"),
    TRANSFORMADO_POSITIVO(8, "Transformado Positivo"),
    TRASEGADO_PARCIAL(9, "Trasegado parcial"), //valido para antenciones que tienen peso pendiente de trasegars;
    PACKING_PARCIAL(10, "Packing parcial"),
    SECADO(11, "Packing parcial"),
    SECADO_LIMPIADO(12, "Packing parcial"),
    LIMPIADO(13, "Packing parcial"),
    REINTEGRO(14, "Reintegro" )
    ;

    public static int ANULADO_ = 0;
    public static int ATENCION_ = 1;
    public static int COMPRA_ = 2;
    public static int TRANSFORMADO_ = 3;
    public static int TRASEGADO_ = 4;
    public static int PACKING_ = 5;
    public static int REMESADO_ = 6;
    public static int REMESADO_RECIBIDO_ = 7;
    public static int TRANSFORMADO_POSITIVO_ = 8; //solo para productos organicos contaminados o convertidos.

    private Integer id;
    private String descripcion;

    EstadosProcesoEnum(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public static EstadosProcesoEnum getById(Integer id) {
        for (EstadosProcesoEnum e : values()) {
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
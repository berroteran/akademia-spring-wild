package com.machupichu.zonas.model;

public enum EventosEnum {

    FALLA_BASCULA("Atencion. Falla de Bascula"),
    FALLA_HUMEDAD("Atencion. Ingreso Manual de Humedad."),
    ATENCION_MERMA_SUPERADA("Atencion. Limite Merma superado"),
    ATENCION_COMPRA_PRIMER_AVISO("Atencion porcentaje de compra superado 1er Aviso"),
    ATENCION_COMPRA_SEGUNDO_AVISO("Atencion porcentaje de compra superado 2do Aviso"),
    ATENCION_COMPRA_TERCER_AVISO("Atencion porcentaje de compra superado 3er Aviso"),
    EVENTO_4("Ingreso existencia");


    public final String nombre;

    EventosEnum(String nombre) {
        this.nombre = nombre;
    }

    public static EventosEnum obtenerPorValor(String label) {
        for (EventosEnum e : values()) {
            if (e.toString().equals(label)) {
                return e;
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }
}
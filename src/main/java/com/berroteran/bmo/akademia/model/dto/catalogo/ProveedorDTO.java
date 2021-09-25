package com.berroteran.bmo.akademia.model.dto.catalogo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProveedorDTO implements Serializable {

    private String nombre;
    private String tipo;
    private String noDocumento;
    private Boolean organico;
    private BigDecimal anticipo;
    private BigDecimal credito;
    private Integer hectarea;
    private Integer capCosecha;
    private Integer maxKilos;
    private Integer comprado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    public Boolean getOrganico() {
        return organico;
    }

    public void setOrganico(Boolean organico) {
        this.organico = organico;
    }

    public BigDecimal getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(BigDecimal anticipo) {
        this.anticipo = anticipo;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public Integer getHectarea() {
        return hectarea;
    }

    public void setHectarea(Integer hectarea) {
        this.hectarea = hectarea;
    }

    public Integer getCapCosecha() {
        return capCosecha;
    }

    public void setCapCosecha(Integer capCosecha) {
        this.capCosecha = capCosecha;
    }

    public Integer getMaxKilos() {
        return maxKilos;
    }

    public void setMaxKilos(Integer maxKilos) {
        this.maxKilos = maxKilos;
    }

    public Integer getComprado() {
        return comprado;
    }

    public void setComprado(Integer comprado) {
        this.comprado = comprado;
    }
}

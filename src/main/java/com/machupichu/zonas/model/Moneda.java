package com.machupichu.zonas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Moneda extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMoneda")
    private Integer id;

    private String signo;
    private String codigo;
    private String descripcion;
    private Boolean defecto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Boolean getDefecto() {
        return defecto != null ? defecto : false;
    }

    public void setDefecto(Boolean defecto) {
        this.defecto = defecto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Moneda moneda = (Moneda) obj;
        return this.id != null && Objects.equals(this.id, moneda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

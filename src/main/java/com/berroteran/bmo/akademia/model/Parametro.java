package com.berroteran.bmo.akademia.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SeqParametro", sequenceName = "parametro_id_seq", allocationSize = 1)
public class Parametro extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqParametro")
    private Integer id;

    private String clave;
    private String tipoDato;
    private String valor;

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

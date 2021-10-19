package com.berroteran.bmo.akademia.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "seqMateria", sequenceName = "seqMateria", allocationSize = 1 )
public class Materia extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMateria" )
    private Integer id;

    private String nombre;
    private CursoNivelEnum nivel = CursoNivelEnum.ANULADO;
    private String descripcion;
    private String intructor;
    private LocalDate fechaInicio;

    //duracion horas
    private Integer duracionh;

    private Boolean activo;



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CursoNivelEnum getNivel() {
        return nivel;
    }
    public void setNivel(CursoNivelEnum nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIntructor() {
        return intructor;
    }

    public void setIntructor(String intructor) {
        this.intructor = intructor;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}

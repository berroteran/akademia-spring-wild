package com.berroteran.bmo.akademia.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "seqCurso", sequenceName = "seqCurso", allocationSize = 1 )
public class Curso extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCurso" )
    private Integer id;

    private String nombre;
    private Integer nivel =1;
    private String descripcion;
    private String intructor;
    private String generacion;
    private LocalDate fechaInicio;
    private Integer cupostotales;
    private Integer cuposDisponibles;

    @ManyToOne
    private Oficina sucursal;

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

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
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
}

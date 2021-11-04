package com.berroteran.bmo.akademia.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "seqCursoMat", sequenceName = "seqCursoMat", allocationSize = 1 )
public class Curso extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCursoMat" )
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Oficina sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Horario horario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Materia materia;

    private String comentarios;

    @Column(nullable = false)
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private Double precio;

    private Integer cupos;
    private Integer disponibles;

    private Boolean activo = Boolean.TRUE;



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public Oficina getSucursal() {
        return sucursal;
    }

    public void setSucursal(Oficina sucursal) {
        this.sucursal = sucursal;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    public Integer getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Integer disponibles) {
        this.disponibles = disponibles;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getNombre(){
        return materia.getNombre() + " - "  + horario.getNombre();
    }

    public String getLabel(){
        return materia.getNombre() + " - "  + horario.getNombre() + ", Cupos: " + this.getDisponibles() ;
    }


    public Double getPrecio() {
        return precio == null ? 0d : precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecioBD(){
        return BigDecimal.valueOf(getPrecio());
    }

}

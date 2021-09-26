package com.berroteran.bmo.akademia.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seqMatricula", sequenceName = "seqMatricula", allocationSize = 1 )
public class Matricula extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMatricula" )
    private Integer id;
    private Integer norecibo;
    private LocalDate fechaMatricula;
    private BigDecimal cantidadPagada;
    private BigDecimal descuento;

    @ManyToOne
    @JoinColumn( )
    private Cliente alumno;

    @ManyToOne
    @JoinColumn
    private Curso curso;

    private String comoSupo;

    private boolean activo;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula oficina = (Matricula) o;
        return id.equals(oficina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNorecibo() {
        return norecibo;
    }

    public void setNorecibo(Integer norecibo) {
        this.norecibo = norecibo;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public BigDecimal getCantidadPagada() {
        return cantidadPagada;
    }

    public void setCantidadPagada(BigDecimal cantidadPagada) {
        this.cantidadPagada = cantidadPagada;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public Cliente getAlumno() {
        return alumno;
    }

    public void setAlumno(Cliente alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getComoSupo() {
        return comoSupo;
    }

    public void setComoSupo(String comoSupo) {
        this.comoSupo = comoSupo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

package com.berroteran.bmo.akademia.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seqCliente", sequenceName = "seqCliente", allocationSize = 1 )
public class Cliente extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente" )
    private Integer id;

    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres == null ? "" : nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

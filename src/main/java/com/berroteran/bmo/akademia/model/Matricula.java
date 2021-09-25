package com.berroteran.bmo.akademia.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seqMatricula", sequenceName = "seqMatricula", allocationSize = 1 )
public class Matricula extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMatricula" )
    private Integer id;


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


}

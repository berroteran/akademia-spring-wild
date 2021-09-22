package com.machupichu.zonas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "catalogo")
@SequenceGenerator(name = "seqcatalogo", sequenceName = "seqcatalogo_id_seq", allocationSize = 1)
public class Catalogo extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcatalogo")
    private Integer id;

    private String codigo;
    private String descripcion;
    private Long catalogoId;
    private Catalogo catalogoEntity;

    @Basic
    @Column(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "catalogo_id", insertable = false, updatable = false)
    public Long getCatalogoId() {
        return catalogoId;
    }

    public void setCatalogoId(Long catalogoId) {
        this.catalogoId = catalogoId;
    }

    @JoinColumn(name = "catalogo_id",referencedColumnName = "id")
    @ManyToOne
    public Catalogo getCatalogoEntity() {
        return catalogoEntity;
    }

    public void setCatalogoEntity(Catalogo catalogoEntity) {
        this.catalogoEntity = catalogoEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Catalogo)) return false;
        if (!super.equals(o)) return false;
        Catalogo catalogo = (Catalogo) o;
        return Objects.equals(codigo, catalogo.codigo) &&
                Objects.equals(descripcion, catalogo.descripcion) &&
                Objects.equals(catalogoId, catalogo.catalogoId) &&
                Objects.equals(catalogoEntity, catalogo.catalogoEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codigo, descripcion, catalogoId, catalogoEntity);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

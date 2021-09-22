package com.machupichu.zonas.model;

import com.machupichu.zonas.view.bean.BaseBackBean;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "seq_bitacora_impresion", sequenceName = "seq_bitaroca_impresion", allocationSize = 1)
public class BitacoraImpresion extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bitacora_impresion")
    private Integer id;

    @Column(name = "pantalla")
    private String pantalla;

    @Column(name = "reporte")
    private String reporte;

    @Column(name = "documento")
    private String documento;

    @Column(name = "usuario_imprime")
    private String usuarioImprime;

    @Column(name = "fecha_impresion")
    private LocalDateTime fechaImpresion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getUsuarioImprime() {
        return usuarioImprime;
    }

    public void setUsuarioImprime(String usuarioImprime) {
        this.usuarioImprime = usuarioImprime;
    }

    public LocalDateTime getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(LocalDateTime fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}

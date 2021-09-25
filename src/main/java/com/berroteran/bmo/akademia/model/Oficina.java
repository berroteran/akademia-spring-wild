package com.berroteran.bmo.akademia.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seqOficina", sequenceName = "seqOficina", allocationSize = 1 )
public class Oficina extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOficina" )
    private Integer id;

    //@Column(length = 10)
    //private String codigo;

    @Column(length = 30)
    private String nombre;

    @Column(length = 8, name = "centro_sap")
    private String centroSap;

    @Column(length = 30)
    private String zona;

    private String sede;

    @Column(length = 500)
    private String direccion;

    @Column(name = "doc_serie_convencional", length = 4)
    private String documentoSerieConvencional;

    @Column(name = "doc_serie_organico", length = 4)
    private String documentoSerieOrganico;

    @Column(name = "doc_serie_recibo_egreso", length = 6)
    private String documentoSerieReciboEgreso;

    @Column(name = "consecutivo_recibo_egreso")
    private Long consecutivoReciboEgreso;

    @Column(name = "no_reporte_production_trans")
    private Integer noReporteProductionTrans;

    @Column(name = "c3", length = 2)
    private String c3;

    @Column(name = "c4", length = 2)
    private String c4;

    private boolean activo;


    public String getCodigo() {
        return getCentroSap();
    }

    public void setCodigo(String codigo) {
        this.centroSap = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCentroSap() {
        return centroSap == null ? "" : centroSap;
    }

    public void setCentroSap(String centroSap) {
        this.centroSap = centroSap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDireccion() {
        return direccion == null ? "" : direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getDocumentoSerieConvencional() {
        return documentoSerieConvencional;
    }

    public void setDocumentoSerieConvencional(String documentoSerieConvencional) {
        this.documentoSerieConvencional = documentoSerieConvencional;
    }

    public String getDocumentoSerieOrganico() {
        return documentoSerieOrganico;
    }

    public void setDocumentoSerieOrganico(String documentoSerieOrganico) {
        this.documentoSerieOrganico = documentoSerieOrganico;
    }

    public String getDocumentoSerieReciboEgreso() {
        return documentoSerieReciboEgreso;
    }

    public void setDocumentoSerieReciboEgreso(String documentoSerieReciboEgreso) {
        this.documentoSerieReciboEgreso = documentoSerieReciboEgreso;
    }

    public Long getConsecutivoReciboEgreso() {
        return this.consecutivoReciboEgreso;
    }

    public void setConsecutivoReciboEgreso(Long consecutivoReciboEgreso) {
        this.consecutivoReciboEgreso = consecutivoReciboEgreso;
    }

    public String getFormatConsecutivoEgreso(){
        return String.format("%07d", this.consecutivoReciboEgreso == null ? 0 : this.consecutivoReciboEgreso);
    }



    @Override
    public String toString() {
        return "Oficina{" +
                "id=" + id +
                ", codigo='" + centroSap + '\'' +
                ", nombre='" + nombre + '\'' +
                ", centroSap='" + centroSap + '\'' +
                ", zona='" + zona + '\'' +
                ", sede='" + sede + '\'' +
                ", direccion='" + direccion + '\'' +
                ", documentoSerieConvencional='" + documentoSerieConvencional + '\'' +
                ", documentoSerieOrganico='" + documentoSerieOrganico + '\'' +
                ", activo=" + activo +
                '}';
    }

    public String getCodSapYNombre(){
        return getCentroSap() + " " + getNombre();
    }
    public String getCodSapYNombre(String spliter ){
        return getCentroSap() + spliter + getNombre();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oficina oficina = (Oficina) o;
        return id.equals(oficina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getNoReporteProductionTrans() {
        return noReporteProductionTrans == null ? 0 : noReporteProductionTrans;
    }

    public void setNoReporteProductionTrans(Integer noReporteProductionTrans) {
        this.noReporteProductionTrans = noReporteProductionTrans;
    }

    public String getC3() {
        return c3== null ? "" : c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getC4() {
        return c4 == null ? "" : c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }


}

package com.berroteran.bmo.akademia.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seqcorreo", sequenceName = "configuracion_email_id_seq", allocationSize = 1)
public class ConfiguracionEmail extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcorreo")
    private Integer id;

    private String servidor;
    private Integer puerto;
    private String cuenta;
    private String clave;
    private String destino;
    private String correoCc;
    private String correoBcc;
    private String asunto;
    private String mensaje;
    private Boolean estado;

    public ConfiguracionEmail() {

    }

    public ConfiguracionEmail(String servidor, Integer puerto, String cuenta, String clave) {
        this.servidor = servidor;
        this.puerto = puerto;
        this.cuenta = cuenta;
        this.clave = clave;
    }

    @Enumerated(EnumType.STRING)
    private EventosEnum evento;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public Integer getPuerto() {
        return puerto;
    }

    public void setPuerto(Integer puerto) {
        this.puerto = puerto;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getCorreoCc() {
        return correoCc;
    }

    public void setCorreoCc(String correoCc) {
        this.correoCc = correoCc;
    }

    public String getCorreoBcc() {
        return correoBcc;
    }

    public void setCorreoBcc(String correoBcc) {
        this.correoBcc = correoBcc;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje == null ? "" : mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Boolean getEstado() {
        return estado == null ? false : estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public EventosEnum getEvento() {
        return evento;
    }

    public void setEvento(EventosEnum evento) {
        this.evento = evento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfiguracionEmail that = (ConfiguracionEmail) o;
        return id.equals(that.id) &&
                Objects.equals(servidor, that.servidor) &&
                Objects.equals(puerto, that.puerto) &&
                Objects.equals(cuenta, that.cuenta) &&
                Objects.equals(clave, that.clave) &&
                Objects.equals(destino, that.destino) &&
                Objects.equals(correoCc, that.correoCc) &&
                Objects.equals(correoBcc, that.correoBcc) &&
                Objects.equals(asunto, that.asunto) &&
                Objects.equals(mensaje, that.mensaje) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(evento, that.evento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, servidor, puerto, cuenta, clave, destino, correoCc, correoBcc, asunto, mensaje, estado, evento);
    }
}

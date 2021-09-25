package com.berroteran.bmo.akademia.model;

import com.berroteran.bmo.akademia.view.utils.Fechas;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"fecha_creacion", "fecha_modificacion"},
        allowGetters = true
)

public abstract class AbstractEntity implements Serializable {
    public static String MY_TIME_ZONE = "America/Lima";

    static DateTimeFormatter fechaTimeFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_modificacion", nullable = false)
    @LastModifiedDate
    private LocalDateTime fecha_modificacion;

    private String creado_por;
    private String modificado_por;

    @PrePersist
    protected void onCreate() {
        fecha_creacion = Fechas.getFechaHoraActual();
        fecha_modificacion = Fechas.getFechaHoraActual();
        creado_por = (getCurrentAuditor() ==null ? "anonimous": getCurrentAuditor().getLogin());
    }

    @PreUpdate
    protected void onUpdate() {
        fecha_modificacion = Fechas.getFechaHoraActual();
        creado_por = (getCurrentAuditor() ==null ? "anonimous": getCurrentAuditor().getLogin());
    }

    public User getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }else{
            if ( authentication.getPrincipal().getClass().getTypeName().equals("java.lang.String") ){
                return null;
            }else
                return ((User) authentication.getPrincipal());
        }
    }

    public String getCreado_por() {
        return creado_por;
    }

    public void setCreado_por(String creado_por) {
        this.creado_por = creado_por;
    }

    public LocalDateTime getFecha_modificacion() {
        return fecha_modificacion;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fechaActual) {
        this.fecha_creacion = fechaActual;
    }

    public String getModificado_por() {
        return modificado_por;
    }

    public void setModificado_por(String modificado_por) {
        this.modificado_por = modificado_por;
    }

    public String getDataPersistent(){
        return getFecha_creacion().format( fechaTimeFormato ) + " por: " + getCreado_por();
    }

}

package com.machupichu.zonas.model.auditoria;

import com.machupichu.zonas.model.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "auditoria_login")
@SequenceGenerator(name = "seqUser", sequenceName = "seqUser_id_seq", allocationSize = 1)
public class LoginAuditoria  extends AbstractEntity {
    public static final String UPDATE_PASSORD = "Actualizar clave";
    public static final String CUENTA_EXPIRADA = "Cuenta Expirada";
    public static final String CUENTA_DISABLE = "Cuenta desactivada";
    public static final String USUARIO_DESACTIVADO = "Usuario desactivado";
    public static final String LOGIN_GENERAL = "Error login General.";
    public static final String USUARIO_NOEXISTE = "Usuario no existe";
    public static final String PASSWORD_INCORRECTA = "Password incorrecto.";
    public static final String USUARIO_CREADO = "Usuario creado.";
    public static String EXITO = "LOGIN EXITOSO";


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUser")
    private Integer id;

    private String userName;

    private String accion;

    private String mensaje;




    public void setLogin(String login) {
        this.userName = login;
    }

    public String getLogin() {
        return userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}

package com.machupichu.zonas.view.bean.seguridad;

import com.machupichu.zonas.model.User;
import com.machupichu.zonas.service.catalogo.UsuarioService;
import com.machupichu.zonas.view.bean.BaseBackBean;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class UsuariosBackBean extends BaseBackBean implements Serializable {

    @Autowired
    private UsuarioService usuarioService;

    private User usuario = new User();
    private List<User> usuarios;
    private String password;


    public UsuariosBackBean() {
    }


    @PostConstruct
    public void init() {
        this.setUsuarios(usuarioService.findAll());
    }

    public void crear() {
        usuario = new User();
    }

    public void onUsuarioSelected() {
    }



    public void save() {
        try {
            if (password != null) {
                this.usuario.setPassword(usuarioService.changePassword(password));
            }

            usuarioService.saveUsuario( this.getUsuario() );

            if ( getUsuario().getId() != null) {

                showInfoMessage("USUARIO ACTUALIZADO SATISFACTORIAMENTE", "");
            } else {
                showInfoMessage("USUARIO GUARDADO SATISFACTORIAMENTE", "");
            }

            setUsuarios( usuarioService.search("") );
            PrimeFaces.current().executeScript("PF('modalUser').hide()");

        } catch (Exception e) {
            showErrorMessage(getClass().getSimpleName(), e.getMessage(), e);
        }
    }


    public User getUsuario() {
        return usuario;
    }


    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }


    public List<User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<User> usuarios) {
        this.usuarios = usuarios;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


package com.berroteran.bmo.akademia.view.bean.seguridad;

import com.berroteran.bmo.akademia.model.Oficina;
import com.berroteran.bmo.akademia.model.User;
import com.berroteran.bmo.akademia.service.OficinaServicio;
import com.berroteran.bmo.akademia.service.catalogo.UsuarioService;
import com.berroteran.bmo.akademia.view.bean.BaseBackBean;
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

    @Autowired
    private OficinaServicio oficinaService;

    private User usuario = new User();
    private List<User> usuarios;
    private String password;

    private Oficina oficina;
    private List<Oficina> oficinas;


    public UsuariosBackBean() {
    }


    @PostConstruct
    public void init() {
        this.setUsuarios(usuarioService.findAll());
        oficinas = (List<Oficina>) oficinaService.findAll();
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

    public List<Oficina> getOficinas() {
        return oficinas;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }


}


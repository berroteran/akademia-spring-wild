package com.berroteran.bmo.akademia.view.bean.seguridad;

import com.berroteran.bmo.akademia.data.repository.RolesRepository;
import com.berroteran.bmo.akademia.model.Roles;
import com.berroteran.bmo.akademia.model.User;
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
public class RolesBackBean extends BaseBackBean implements Serializable {

    private Roles rol = new Roles();
    private User user;
    private List<Roles> roles;

    @Autowired
    private RolesRepository rolesRepository;


    @PostConstruct
    public void init() {
        this.setRoles(rolesRepository.search());
    }

    public void crear() {
        rol = new Roles();
    }

    public void save() {
        rolesRepository.save(this.getRol());
        if (this.getRol().getId() != null) {
            showInfoMessage("USUARIO ACTUALIZADO SATISFACTORIAMENTE", "");

        } else {
            showInfoMessage("USUARIO GUARDADO SATISFACTORIAMENTE", "");
        }
        this.setRoles(rolesRepository.search());
        PrimeFaces.current().executeScript("PF('modalRoles').hide()");

    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

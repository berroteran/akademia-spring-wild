package com.machupichu.zonas.view.bean.configuracion;

import com.machupichu.zonas.model.Oficina;
import com.machupichu.zonas.view.bean.BaseBackBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionListener;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class OficinaBackBean extends BaseBackBean implements Serializable {


    private Oficina oficina;

    @PostConstruct
    public void init() {

    }

    public ActionListener getCrear() {
        return null;
    }

    public List<Oficina> getOficinas() {
        return null;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public void getOnOficinaSelected() {
    }

    public void  cerrarModalOficina() {
    }
}

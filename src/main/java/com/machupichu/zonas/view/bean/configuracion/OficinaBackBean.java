package com.machupichu.zonas.view.bean.configuracion;

import com.machupichu.zonas.model.Oficina;
import com.machupichu.zonas.service.OficinaServicio;
import com.machupichu.zonas.view.bean.BaseBackBean;
import com.machupichu.zonas.view.bean.SessionBackBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionListener;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class OficinaBackBean extends BaseBackBean implements Serializable {

    @Autowired
    private SessionBackBean sessionBackBean;

    @Autowired
    private OficinaServicio oficinaService;


    private Oficina oficina;
    private List<Oficina> oficinas;


    @PostConstruct
    public void init() {
        oficinas = (List<Oficina>) oficinaService.findAll();
    }

    public void onload(){

    }

    public ActionListener crear() {
        try{

            oficina = new Oficina();

        }catch (Exception e){
            showErrorMessage("Registro de Oficinas", e.getMessage());
        }
        return null;
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

    public void getOnOficinaSelected() {
    }

    public void  cerrarModalOficina() {
    }

    public ActionListener save() {
        try {

            oficinaService.save(this.getOficina());

            showInfoMessage("OFICINA GUARDADO SATISFACTORIAMENTE", "");
        }catch(Exception e){
            showErrorMessage("Registro de Oficinas", e.getMessage());
        }
        return null;
    }

    public void setOficinas(List<Oficina> oficinas) {
        this.oficinas = oficinas;
    }
}

package com.berroteran.bmo.akademia.view.bean;

import com.berroteran.bmo.akademia.model.Matricula;
import com.berroteran.bmo.akademia.model.Oficina;
import com.berroteran.bmo.akademia.service.OficinaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionListener;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class MatriculaBackBean extends BaseBackBean implements Serializable {

    @Autowired
    private SessionBackBean sessionBackBean;

    @Autowired
    private OficinaServicio oficinaService;


    private Oficina oficina;
    private List<Oficina> oficinas;
    private Matricula matricula;

    @PostConstruct
    public void init() {
        oficinas = (List<Oficina>) oficinaService.findAll();
    }

    public void onload(){

    }

    public void onOficinaSelected(){
        
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

package com.berroteran.bmo.akademia.view.bean;

import com.berroteran.bmo.akademia.model.Cliente;
import com.berroteran.bmo.akademia.model.Oficina;
import com.berroteran.bmo.akademia.service.OficinaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionListener;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class PlantillaBackBean extends BaseBackBean implements Serializable {

    @Autowired
    private OficinaServicio oficinaService;


    private Oficina oficina;

    private Cliente alumno;
    private Iterable<Cliente> alumnos;


    @PostConstruct
    public void init() {

    }

    public void onload(){

    }

    public void onOficinaSelected(){
        
    }

    public ActionListener crear() {
        try{

        }catch (Exception e){
            showErrorMessage("Registro de Oficinas", e.getMessage());
        }
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

    public ActionListener save() {
        try {

            showInfoMessage("CURSO GUARDADO SATISFACTORIAMENTE", "");
        }catch(Exception e){
            showErrorMessage("Registro de curso", e.getMessage());
        }
        return null;
    }

    public void cargarDatos(){

    }

    public void cursoSelected(){

    }

    public void estadisticas(){
        try{

            showInfoMessage("Estadistica", "Función aún no implementada.");
        }catch(Exception e){
            showErrorMessage("Estadistica", e.getMessage());
        }
    }



}

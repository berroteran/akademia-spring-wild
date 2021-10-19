package com.berroteran.bmo.akademia.view.bean;

import com.berroteran.bmo.akademia.model.CursoNivelEnum;
import com.berroteran.bmo.akademia.model.Materia;
import com.berroteran.bmo.akademia.model.Oficina;
import com.berroteran.bmo.akademia.service.CursoServicio;
import com.berroteran.bmo.akademia.service.HorariosServicio;
import com.berroteran.bmo.akademia.service.MateriasServicio;
import com.berroteran.bmo.akademia.service.OficinaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionListener;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Component
@ViewScoped
public class MateriasBackBean extends BaseBackBean implements Serializable {

    @Autowired
    private OficinaServicio oficinaService;
    @Autowired
    private HorariosServicio horarioServicio;
    @Autowired
    private MateriasServicio materiasServicio;

    private Oficina oficina;
    private List<Oficina> oficinas;
    private List<CursoNivelEnum> horarioNiveles = Arrays.asList(CursoNivelEnum.values());

    private Materia materia;
    private Iterable<Materia> materias;


    @PostConstruct
    public void init() {
        oficinas = (List<Oficina>) oficinaService.findAll();
        materias =  materiasServicio.findAll();
    }

    public void onload(){

    }

    public void onOficinaSelected(){
        
    }

    public ActionListener crear() {
        try{
            materia = new Materia();
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

            materiasServicio.guardarMateria(materia);

            showInfoMessage("CURSO GUARDADO SATISFACTORIAMENTE", "");
        }catch(Exception e){
            showErrorMessage("Registro de horario", e.getMessage());
        }
        return null;
    }

    public void cargarDatos(){

    }

    public void horarioSelected(){

    }

    public void estadisticas(){
        try{

            showInfoMessage("Estadistica", "Función aún no implementada.");
        }catch(Exception e){
            showErrorMessage("Estadistica", e.getMessage());
        }
    }


    public void setOficinas(List<Oficina> oficinas) {
        this.oficinas = oficinas;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Iterable<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Iterable<Materia> materias) {
        this.materias = materias;
    }

    public List<CursoNivelEnum> getCursoNiveles() {
        return horarioNiveles;
    }

    public void setCursoNiveles(List<CursoNivelEnum> horarioNiveles) {
        this.horarioNiveles = horarioNiveles;
    }
}

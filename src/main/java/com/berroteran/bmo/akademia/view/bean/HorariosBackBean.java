package com.berroteran.bmo.akademia.view.bean;

import com.berroteran.bmo.akademia.model.CursoNivelEnum;
import com.berroteran.bmo.akademia.model.Horario;
import com.berroteran.bmo.akademia.model.Materia;
import com.berroteran.bmo.akademia.model.Oficina;
import com.berroteran.bmo.akademia.service.CursoServicio;
import com.berroteran.bmo.akademia.service.HorariosServicio;
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
public class HorariosBackBean extends BaseBackBean implements Serializable {

    @Autowired
    private OficinaServicio oficinaService;
    @Autowired
    private CursoServicio cursoServicio;
    @Autowired
    private HorariosServicio horarioServicio;

    private Oficina oficina;
    private List<Oficina> oficinas;
    private List<CursoNivelEnum> cursoNiveles = Arrays.asList(CursoNivelEnum.values());

    private Horario horario;
    private Iterable<Horario> horarios;


    @PostConstruct
    public void init() {
        oficinas = (List<Oficina>) oficinaService.findAll();
        horarios =  horarioServicio.findAll();
    }

    public void onload(){

    }

    public void onOficinaSelected(){
        
    }

    public ActionListener crear() {
        try{
            horario = new Horario();
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

            horarioServicio.guardarHorario( horario );

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


    public void setOficinas(List<Oficina> oficinas) {
        this.oficinas = oficinas;
    }

    public Horario getCurso() {
        return horario;
    }

    public void setCurso(Horario Horario) {
        this.horario = Horario;
    }

    public Iterable<Horario> getCursos() {
        return horarios;
    }

    public void setCursos(Iterable<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<CursoNivelEnum> getCursoNiveles() {
        return cursoNiveles;
    }

    public void setCursoNiveles(List<CursoNivelEnum> cursoNiveles) {
        this.cursoNiveles = cursoNiveles;
    }
}

package com.berroteran.bmo.akademia.view.bean;

import com.berroteran.bmo.akademia.model.*;
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
public class CursoBackBean extends BaseBackBean implements Serializable {

    @Autowired
    private SessionBackBean sessionBackBean;

    @Autowired
    private OficinaServicio oficinaService;

    @Autowired
    private CursoServicio cursoServicio;

    @Autowired
    private MateriasServicio materiasServicio;

    @Autowired
    private HorariosServicio horariosServicio;


    private Oficina oficina;
    private List<Oficina> oficinas;
    private List<CursoNivelEnum> cursoNiveles = Arrays.asList(CursoNivelEnum.values());

    private Curso curso;
    private Iterable<Curso> cursos;

    private Horario horario;
    private Iterable<Horario> horarios;

    private Materia materia;
    private Iterable<Materia> materias;



    @PostConstruct
    public void init() {
        oficinas = (List<Oficina>) oficinaService.findAll();
        cursos =  cursoServicio.findAllwData();
        //
        horarios = horariosServicio.findAll();
        materias = materiasServicio.findAll();
    }

    public void onload(){

    }

    public void onOficinaSelected(){
        
    }

    public ActionListener crear() {
        try{
            curso = new Curso();
            curso.setActivo(true);

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

            cursoServicio.guardarCurso( curso );

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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Iterable<Curso> getCursos() {
        return cursos;
    }

    public Oficina getOficinaFromUser(){
        return sessionBackBean.getOficina();
    }

    public void setCursos(Iterable<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<CursoNivelEnum> getCursoNiveles() {
        return cursoNiveles;
    }

    public void setCursoNiveles(List<CursoNivelEnum> cursoNiveles) {
        this.cursoNiveles = cursoNiveles;
    }

    public OficinaServicio getOficinaService() {
        return oficinaService;
    }

    public void setOficinaService(OficinaServicio oficinaService) {
        this.oficinaService = oficinaService;
    }

    public CursoServicio getCursoServicio() {
        return cursoServicio;
    }

    public void setCursoServicio(CursoServicio cursoServicio) {
        this.cursoServicio = cursoServicio;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Iterable<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(Iterable<Horario> horarios) {
        this.horarios = horarios;
    }


    public Iterable<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Iterable<Materia> materias) {
        this.materias = materias;
    }
}

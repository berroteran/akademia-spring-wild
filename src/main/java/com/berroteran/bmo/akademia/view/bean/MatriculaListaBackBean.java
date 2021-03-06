package com.berroteran.bmo.akademia.view.bean;

import com.berroteran.bmo.akademia.model.*;
import com.berroteran.bmo.akademia.service.CursoServicio;
import com.berroteran.bmo.akademia.service.MatriculaServicio;
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
public class MatriculaListaBackBean extends BaseBackBean implements Serializable {

    @Autowired
    private SessionBackBean sessionBackBean;

    @Autowired
    private OficinaServicio oficinaService;

    @Autowired
    private MatriculaServicio matriculaServicio;
    @Autowired
    private CursoServicio cursoServicio;


    private Oficina oficina;
    private List<Oficina> oficinas;
    private Matricula matricula;
    private Iterable<Matricula> matriculas;
    private List<Cliente> alumnosLista;
    private Cliente alumno;

    private List<Curso> cursos;
    private Curso curso;

    @PostConstruct
    public void init() {
        oficinas = (List<Oficina>) oficinaService.findAll();
        matriculas = matriculaServicio.findAll();
    }

    public void onload() {

    }

    public void onOficinaSelected() {

    }

    public ActionListener crear() {
        try {

            oficina = new Oficina();

        } catch (Exception e) {
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

    public void cerrarModalOficina() {
    }

    public void setOficinas(List<Oficina> oficinas) {
        this.oficinas = oficinas;
    }


    //= ======

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public List<Cliente> getAlumnosLista() {
        return alumnosLista;
    }

    public void setAlumnosLista(List<Cliente> alumnosLista) {
        this.alumnosLista = alumnosLista;
    }

    public Cliente getAlumno() {
        return alumno;
    }

    public void setAlumno(Cliente alumno) {
        this.alumno = alumno;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Iterable<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Iterable<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Oficina getOficinaFromUser() {
        return sessionBackBean.getOficina();
    }
}

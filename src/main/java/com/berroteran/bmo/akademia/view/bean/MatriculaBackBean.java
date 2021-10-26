package com.berroteran.bmo.akademia.view.bean;

import com.berroteran.bmo.akademia.model.*;
import com.berroteran.bmo.akademia.service.AlumnoServicio;
import com.berroteran.bmo.akademia.service.CursoServicio;
import com.berroteran.bmo.akademia.service.MatriculaServicio;
import com.berroteran.bmo.akademia.service.OficinaServicio;
import org.primefaces.PrimeFaces;
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

    @Autowired
    private MatriculaServicio matriculaServicio;
    @Autowired
    private CursoServicio cursoServicio;
    @Autowired
    private AlumnoServicio alumnoServicio;

    private Oficina oficina;
    private List<Oficina> oficinas;
    private Matricula matricula;
    private List<Cliente> alumnosLista;
    private Cliente alumno;

    private List<Curso> cursos;

    @PostConstruct
    public void init() {
        oficinas = (List<Oficina>) oficinaService.findAll();
        alumnosLista = (List<Cliente>) alumnoServicio.findAll();
        //
        matricula = new Matricula();
        matricula.setSucursal( getOficinaFromUser() );
        newAlumno();
        matricula.setAlumno( alumno  );
        PrimeFaces.current().ajax().update("form-matricula");
        PrimeFaces.current().ajax().update("txtNombres");
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

    public void saveMatricula() {
        try {
            getMatricula().setAlumno( alumno );
            matriculaServicio.saveMatricula( getMatricula() );

            showInfoMessage("MATRICULA GUARDADA SATISFACTORIAMENTE", "");
        }catch(Exception e){
            e.printStackTrace();
            showErrorMessage("Matriculando", e.getMessage());
        }
    }

    public void setOficinas(List<Oficina> oficinas) {
        this.oficinas = oficinas;
    }

    public void actualizaCursos(){
        try {
            cursos = cursoServicio.findCursosActivosBySucursal(matricula.getSucursal());
        }catch (Exception e){
            e.printStackTrace();
            showErrorMessage("Actualizar Curso", e.getMessage());
        }
    }

    public Oficina getOficinaFromUser(){
        return sessionBackBean.getOficina();
    }

    public void actualizaAlumno(){
        try{
            if ( matricula.getAlumno() == null){
                matricula.setAlumno( newAlumno() );
            }
            if ( matricula.getAlumno() != null){
                alumno = matricula.getAlumno();
                PrimeFaces.current().ajax().update("txtNombres");
            }
        }catch(Exception e){
            showErrorMessage("Obtener Alumno", e.getMessage());
        }
    }


    private Cliente newAlumno() {
        System.out.println("Creando nuevo alumno");

        alumno = new Cliente();
        alumno.setNombres("");
        alumno.setApellidos("");
        alumno.setDni("");
        alumno.setTelefono("");
        return alumno;
    }


    public void actualizaDescuento(){

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

}

package com.berroteran.bmo.akademia.view.bean.configuracion;

import com.berroteran.bmo.akademia.model.Curso;
import com.berroteran.bmo.akademia.model.Oficina;
import com.berroteran.bmo.akademia.service.CursoServicio;
import com.berroteran.bmo.akademia.service.OficinaServicio;
import com.berroteran.bmo.akademia.view.bean.BaseBackBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionListener;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class CursoBackBean extends BaseBackBean implements Serializable {

    @Autowired
    private OficinaServicio oficinaService;
    @Autowired
    private CursoServicio cursoServicio;

    private Oficina oficina;
    private List<Oficina> oficinas;

    private Curso curso;
    private Iterable<Curso> cursos;


    @PostConstruct
    public void init() {
        oficinas = (List<Oficina>) oficinaService.findAll();
        cursos =  cursoServicio.findAll();
    }

    public void onload(){

    }

    public void onOficinaSelected(){
        
    }

    public ActionListener crear() {
        try{
            curso = new Curso();
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

    public void setCursos(Iterable<Curso> cursos) {
        this.cursos = cursos;
    }
}

package com.berroteran.bmo.akademia.service;

import com.berroteran.bmo.akademia.data.repository.AlumnoRepository;
import com.berroteran.bmo.akademia.data.repository.CursoRepository;
import com.berroteran.bmo.akademia.data.repository.MatriculaRepository;
import com.berroteran.bmo.akademia.data.repository.OficinaRepository;
import com.berroteran.bmo.akademia.model.Curso;
import com.berroteran.bmo.akademia.model.Matricula;
import com.berroteran.bmo.akademia.model.Oficina;
import com.berroteran.bmo.akademia.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MatriculaServicio {

    private static final Logger LOGGER = Logger.getLogger(MatriculaServicio.class.getName());

    @Autowired
    private OficinaRepository OficinaRepositorio;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;


    public Iterable<Matricula> findAll() {
        return matriculaRepository.getAllDataActivas();
    }


    public Collection<Oficina> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return (Collection<Oficina>) OficinaRepositorio.findAll();
        } else {
            return OficinaRepositorio.search(stringFilter);
        }
    }

    public long count() {
        return OficinaRepositorio.count();
    }

    public void delete(Oficina Oficina) {
        OficinaRepositorio.delete(Oficina);
    }


    @Transactional
    public Matricula saveMatricula(Matricula matricula) throws BusinessException {
        if (matricula.getSucursal() == null) {
            LOGGER.log(Level.SEVERE, "La Sucursal esta nulo. ¿Está seguro que está bien escrito?");
            throw new BusinessException("La Sucursal esta nulo. Debe seleccionar una sucursal.");
        }
        if (matricula.getCurso() == null) {
            LOGGER.log(Level.SEVERE, "El curso está nulo. ¿Está seguro que está bien escrito?");
            throw new BusinessException("El curso está  nulo. ¿Está seguro que está bien escrito?");
        }
        if (matricula.getFechaMatricula() == null) throw new BusinessException("La fecha de Matricula no puede ser nulo");

        if (matricula.getAlumno() == null) throw new BusinessException("El alumno es requerido para poder matricular.");

        if (matricula.getCantidadPagada() == null) throw new BusinessException("EL monto pagado es requerido para poder matricular.");

        if (matricula.getCantidadPagada().doubleValue() < 0d) throw new BusinessException("EL monto pagado no puede ser menor a 0.");

        if (matricula.getCantidadPagada().doubleValue() > (matricula.getCurso().getPrecio() - matricula.getDescuento().doubleValue())) throw new BusinessException("EL monto pagado no puede ser mayor al monto con descuento..");

        if (matricula.getCurso().getDisponibles() == 0) throw new BusinessException("No se puede guardar esta matricula, ya no tiene cupos.");

        if (matricula.getAlumno().getId() != null) {
            matricula.setAlumno(alumnoRepository.findById(matricula.getAlumno().getId()).get());
            if (matricula.getAlumno() == null) {
                throw new BusinessException("El alumno que desea matricular, no existe.");
            }
        }

        Curso c = cursoRepository.findById(matricula.getCurso().getId()).get();
        if (c == null) throw new BusinessException("El curso que intenta actualizar no existe.");

        c.setDisponibles(c.getDisponibles() - 1);
        cursoRepository.save(c);

        matricula.setActivo(true);

        return matriculaRepository.save(matricula);
    }


    public List<Matricula> getAllActiva() {
        //return matriculaRepository.getAllActivos();
        return null;
    }

}

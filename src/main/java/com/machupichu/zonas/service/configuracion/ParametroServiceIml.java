package com.machupichu.zonas.service.configuracion;

import com.machupichu.zonas.data.repository.ParametroRepository;
import com.machupichu.zonas.model.Parametro;
import com.machupichu.zonas.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ParametroServiceIml  implements ParametroService{

    @Autowired
    private ParametroRepository repository;

    @Transactional
    @Override
    public List<Parametro> findAll() {

        Iterable<Parametro> iterable = repository.findAll();
        if( iterable != null ){
            return StreamSupport.stream(iterable.spliterator(), false)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    @Transactional
    @Override
    public Parametro getById(Integer pId) {
        Optional opt = repository.findById(pId);
        return opt.isPresent() ? (Parametro) opt.get() : null;
    }

    @Transactional
    @Override
    public Parametro getByClave(String pClave) {
        return repository.findByClave(pClave);
    }

    @Override
    public List<Parametro> getAllParameters() {
        return (List<Parametro>) repository.findAll();
    }

    @Override
    @Transactional
    public void saveParametro(String parametro, String valor)  {
        Parametro par  = repository.findByClave(parametro);
        if ( par == null ) {
            par = new Parametro();
            par.setClave( parametro );
        }
        par.setValor( valor );

        repository.save( par );
    }

    @Override
    public String getValueByClave(String parametroClave) throws BusinessException {
        if ( parametroClave == null || parametroClave.isEmpty() )
            throw new BusinessException("Debe indicar el parametro a buscar");
        String valor =  repository.getValue( parametroClave );
        return valor == null ? "0" : valor  ;
    }

    @Override
    public String getValueByClave(String parametroClave, String valorDefecto) throws BusinessException {
        if ( parametroClave == null || parametroClave.isEmpty() )
            throw new BusinessException("Debe indicar el parametro a buscar");
        if ( valorDefecto == null || valorDefecto.isEmpty() )
            throw new BusinessException("Debe indicar el valor por defecto.");

        String valor =  repository.getValue( parametroClave );
        System.out.println("LGBT: valor del parametro recuperado desde al base de dato: " + valor);
        return valor == null ?  valorDefecto : valor  ;
    }

    @Transactional
    public void saveAll(List<Parametro> params) {
        repository.saveAll( params);
    }
}

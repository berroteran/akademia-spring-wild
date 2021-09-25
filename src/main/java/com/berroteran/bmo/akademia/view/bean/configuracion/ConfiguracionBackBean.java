package com.berroteran.bmo.akademia.view.bean.configuracion;

import com.berroteran.bmo.akademia.model.ConfiguracionEmail;
import com.berroteran.bmo.akademia.model.EventosEnum;
import com.berroteran.bmo.akademia.model.Parametro;
import com.berroteran.bmo.akademia.service.configuracion.EmailService;
import com.berroteran.bmo.akademia.service.configuracion.ParametroServiceIml;
import com.berroteran.bmo.akademia.utils.BusinessException;
import com.berroteran.bmo.akademia.view.bean.BaseBackBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Component
@ViewScoped
public class ConfiguracionBackBean extends BaseBackBean implements Serializable {

    @Autowired
    public ConfiguracionBackBean(final EmailService emailService) {
        this.emailService = emailService;
    }

    @Autowired
    private ParametroServiceIml parametroService;


    private ConfiguracionEmail configuracionEmail = new ConfiguracionEmail();

    private List<EventosEnum> eventos = Arrays.asList(EventosEnum.values());
    private EventosEnum eventoSelected;
    private List<ConfiguracionEmail> configuraciones;

    private final EmailService emailService;

    private List<Parametro> params;
    private String parametro;


    @PostConstruct
    public void init() {
        this.setConfiguraciones(emailService.search(""));
        configuracionEmail = this.configuraciones.get(0);
        this.eventoSelected = configuracionEmail.getEvento();
        //
        params =   parametroService.getAllParameters();

    }


    public List<EventosEnum> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventosEnum> eventos) {
        this.eventos = eventos;
    }

    public void crear() {
        configuracionEmail = new ConfiguracionEmail();
    }


    public void saveMailConfiguracion() {
        boolean persistedEntity = this.getConfiguracionEmail().getId() != null;
        if (this.configuracionEmail.getEvento() == null) {
            this.configuracionEmail.setEvento(eventoSelected);
        }

        emailService.save(this.getConfiguracionEmail());

        if (this.getConfiguracionEmail().getId() != null) {
            if (persistedEntity) {
                showInfoMessage("CONFIGURACION DE CORREO ACTUALIZADA SATISFACTORIAMENTE", "");
            } else {
                showInfoMessage("CONFIGURACION DE CORREO GUARepesaRDADA SATISFACTORIAMENTE", "");
            }
            this.setConfiguraciones(emailService.search(""));
        }
    }


    public void probarConexion() {
        if (emailService.validarConexionSmtpServer(configuracionEmail.getServidor(), configuracionEmail.getPuerto(), configuracionEmail.getCuenta(), configuracionEmail.getClave())) {
            showInfoMessage("Conectado correctamente", "");
        } else {
            showErrorMessage("Error al conectarse al servidor", "");
        }
    }

    public void enviarCorreoDePrueba() {
        try {
            if (configuracionEmail.getEvento() != null) {
                emailService.enviarCorreo(configuracionEmail.getEvento(), "Esto es un correo de prueba.");
            }
        } catch (Exception e) {
            showErrorMessage("No se pudo enviar el correo.", e.getMessage());
        }
    }


    public void cancelar() {
        this.configuracionEmail = new ConfiguracionEmail();
    }

    public void onEventoSelected() {
        if (this.eventoSelected != null) {
            //dato del servidor, puerto, cuenta y clave podria mantenerse por tanto obtenemos su valor
            ConfiguracionEmail tmp = this.configuraciones.get(0);
            this.configuracionEmail = this.configuraciones.stream().filter(x -> x.getEvento().toString().equals(eventoSelected.toString())).findFirst().orElse(new ConfiguracionEmail(tmp.getServidor(), tmp.getPuerto(), tmp.getCuenta(), tmp.getClave()));

        }
    }



    public void saveParametro(String parametro, String valor){
        try {
            if ( parametro.isEmpty() )
                throw new BusinessException("No se recuperoo el parametro a buscar");

            if ( valor == null ||  valor.isEmpty())
                throw new BusinessException("No se ha indicado el valor a guardar");

            parametroService.saveParametro(parametro, valor);

            showInfoMessage("GUARDANDO PARAMETRO", "Parametro guardado satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorMessage("Guardando Parametro: " + parametro, e.getMessage());
        }
    }

    public String obtenerValor(String param){
        System.out.println("valor xx :" + param);
        String v = "";
        for( Parametro p : params ){
            if ( p.getClave().equals(param) )
                v = p.getValor();
        }
        System.out.println("valor VVV:" + v);
        v = v == null ? "0" : v;
        return v;
    }

    public int findIndex(String paraName){
        int index = -1;
        for( Parametro p : params ){
            if ( p.getClave().equals(paraName) ) {
                index = params.indexOf(p);
                break;
            }
        }
        return index;
    }

    public void settingValue(String paraName){
        for( Parametro p : params ){
            if ( p.getClave().equals(paraName) )
                p.setValor( "d");
        }
    }





    public void saveAllSettings(){
        try {
            parametroService.saveAll(params);

            showInfoMessage("GUARDANDO PARAMETRO", "Parametros guardado satisfactoriamente");
        } catch (Exception e) {
            e.printStackTrace();
            showErrorMessage("Guardando Parametro: " + parametro, e.getMessage());
        }
    }



    public ConfiguracionEmail getConfiguracionEmail() {
        return configuracionEmail;
    }

    public void setConfiguracionEmail(ConfiguracionEmail configuracionEmail) {
        this.configuracionEmail = configuracionEmail;
    }

    public List<ConfiguracionEmail> getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(List<ConfiguracionEmail> configuraciones) {
        this.configuraciones = configuraciones;
    }

    public EventosEnum getEventoSelected() {
        return eventoSelected;
    }

    public void setEventoSelected(EventosEnum eventoSelected) {
        this.eventoSelected = eventoSelected;
    }

    public String getParametro(String clave) {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public List<Parametro> getParams() {
        return params;
    }

    public void setParams(List<Parametro> params) {
        this.params = params;
    }


}

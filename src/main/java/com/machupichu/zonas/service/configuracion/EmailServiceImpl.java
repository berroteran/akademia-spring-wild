package com.machupichu.zonas.service.configuracion;


import com.machupichu.zonas.data.repository.ConfiguracionEmailRepository;
import com.machupichu.zonas.model.ConfiguracionEmail;
import com.machupichu.zonas.model.EventosEnum;
import com.machupichu.zonas.view.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger LOGGER = Logger.getLogger(EmailServiceImpl.class.getName());

    @Autowired
    private ConfiguracionEmailRepository configuracionEmailRepository;


    //public EmailServiceImpl(final ConfiguracionEmailRepository configuracionEmailRepository) {
    //    this.configuracionEmailRepository = configuracionEmailRepository;
    //}

    @Transactional
    public void save(ConfiguracionEmail configuracionEmail) {
        if (configuracionEmail == null) {
            LOGGER.log(Level.SEVERE,
                    "La configuracion de correo esta nula. ¿Está seguro que está bien escrito?");
            return;
        }
        configuracionEmailRepository.save(configuracionEmail);
        configuracionEmailRepository.actualizarConfiguracion(configuracionEmail.getServidor(), configuracionEmail.getPuerto(), configuracionEmail.getCuenta(), configuracionEmail.getClave());
    }

    @Override
    @Transactional
    public List<ConfiguracionEmail> search(String criteria) {
        return configuracionEmailRepository.findAll();
    }


    public void enviarCorreo(EventosEnum evento, String mensaje) throws Exception {
        ConfiguracionEmail configuracionEmail;

        configuracionEmail = configuracionEmailRepository.findByEvento(evento);
        if ( configuracionEmail.getEstado() ) {
            if (configuracionEmail.getEstado()) {
                if (configuracionEmail == null) {
                    LOGGER.log(Level.SEVERE, "No se encontro ninguna configuracion de Email con el evento seleccionado");
                    return;
                }
                Session session = configurarTipoConexion(configuracionEmail);

                EmailUtils.sendEmail(session, configuracionEmail.getCuenta(), configuracionEmail.getDestino(), configuracionEmail.getCorreoCc(), configuracionEmail.getCorreoBcc(), configuracionEmail.getAsunto(), configuracionEmail.getMensaje() + "\n " + mensaje);
            }
        }
    }

    @Override
    public boolean validarConexionSmtpServer(String servidor, Integer puerto, String usuario, String contra) {
        //tipo de encriptacion (TLS o SSL)
        String enctype="";
        return EmailUtils.confirmSMTP(servidor,puerto,usuario,contra,Boolean.FALSE,enctype);
    }


    private Session configurarTipoConexion(ConfiguracionEmail configuracionEmail){

        Properties props = new Properties();
        // TLS
        if (configuracionEmail.getPuerto()==587){
            props.put("mail.smtp.host", configuracionEmail.getServidor()); //SMTP Host
            props.put("mail.smtp.port", configuracionEmail.getPuerto());
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            //SSL
        }else if(configuracionEmail.getPuerto()==465){
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
            props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
            props.put("mail.smtp.port", configuracionEmail.getPuerto()); //SMTP Port

        }else{
            props.put("mail.smtp.host", configuracionEmail.getServidor());
            props.put("mail.smtp.port", configuracionEmail.getPuerto()); //SMTP Port
            props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        }
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(configuracionEmail.getCuenta(), configuracionEmail.getClave());
            }
        };
        return Session.getInstance(props, auth);

    }
}
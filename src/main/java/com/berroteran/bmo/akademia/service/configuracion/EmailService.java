package com.berroteran.bmo.akademia.service.configuracion;

import com.berroteran.bmo.akademia.model.ConfiguracionEmail;
import com.berroteran.bmo.akademia.model.EventosEnum;

import java.util.List;


public interface EmailService {

    void save(ConfiguracionEmail configuracionEmail);

    void enviarCorreo(EventosEnum evento, String mensaje) throws Exception;

    boolean validarConexionSmtpServer(String servidor, Integer puerto,String usuario, String contra);

    List<ConfiguracionEmail> search(String criteria);
}

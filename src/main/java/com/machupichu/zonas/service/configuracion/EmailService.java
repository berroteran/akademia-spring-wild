package com.machupichu.zonas.service.configuracion;

import com.machupichu.zonas.model.ConfiguracionEmail;
import com.machupichu.zonas.model.EventosEnum;

import java.util.List;


public interface EmailService {

    void save(ConfiguracionEmail configuracionEmail);

    void enviarCorreo(EventosEnum evento, String mensaje) throws Exception;

    boolean validarConexionSmtpServer(String servidor, Integer puerto,String usuario, String contra);

    List<ConfiguracionEmail> search(String criteria);
}

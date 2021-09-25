package com.berroteran.bmo.akademia.model.auditoria;

import com.berroteran.bmo.akademia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.logging.Logger;


@Service
public class LoginAuditoriaServicio {

    private static final Logger LOGGER = Logger.getLogger( LoginAuditoriaServicio.class.getName());

    @Autowired
    private LoginAuditoriaRepository loginAuditoriaRepository;


    @Transactional
    public void saveUsuarioNoexiste(String username) {
        LoginAuditoria auditoria = new LoginAuditoria();
        auditoria.setLogin( username );
        auditoria.setAccion( LoginAuditoria.USUARIO_NOEXISTE );
        //
        loginAuditoriaRepository.save( auditoria );
    }

    @Transactional
    public void saveErrorLoginGeneral(String username) {
        LoginAuditoria auditoria = new LoginAuditoria();
        auditoria.setLogin( username );
        auditoria.setAccion( LoginAuditoria.LOGIN_GENERAL );
        //
        loginAuditoriaRepository.save( auditoria );
    }

    @Transactional
    public void saveUsuarioDesactivad(String username) {
        LoginAuditoria auditoria = new LoginAuditoria();
        auditoria.setLogin( username );
        auditoria.setAccion( LoginAuditoria.USUARIO_DESACTIVADO );
        //
        loginAuditoriaRepository.save( auditoria );
    }

    @Transactional
    public void saveCuentaDisable(String username) {
        LoginAuditoria auditoria = new LoginAuditoria();
        auditoria.setLogin( username );
        auditoria.setAccion( LoginAuditoria.CUENTA_DISABLE );
        //
        loginAuditoriaRepository.save( auditoria );
    }

    @Transactional
    public void saveCuentaExpirada(String username) {
        LoginAuditoria auditoria = new LoginAuditoria();
        auditoria.setLogin( username );
        auditoria.setAccion( LoginAuditoria.CUENTA_EXPIRADA );
        //
        loginAuditoriaRepository.save( auditoria );
    }

    @Transactional
    public void saveUpdatePassword(String username) {
        LoginAuditoria auditoria = new LoginAuditoria();
        auditoria.setLogin( username );
        auditoria.setAccion( LoginAuditoria.UPDATE_PASSORD );
        //
        loginAuditoriaRepository.save( auditoria );
    }


    @Transactional
    public void saveExito(String username) {
        LoginAuditoria auditoria = new LoginAuditoria();
        auditoria.setLogin( username );
        auditoria.setAccion( LoginAuditoria.EXITO );
        //
        loginAuditoriaRepository.save( auditoria );
    }

    @Transactional
    public void savePasswordIncorrecta(String username) {
        LoginAuditoria auditoria = new LoginAuditoria();
        auditoria.setLogin( username );
        auditoria.setAccion( LoginAuditoria.PASSWORD_INCORRECTA );
        //
        loginAuditoriaRepository.save( auditoria );
    }

    @Transactional
    public void usuarioCreado(User usuario) {
        LoginAuditoria auditoria = new LoginAuditoria();
        auditoria.setLogin( usuario.getLogin() );
        auditoria.setAccion( LoginAuditoria.USUARIO_CREADO );
        //
        loginAuditoriaRepository.save( auditoria );
    }

    @Transactional
    public void usuarioActualizado(User usuario) {
        LoginAuditoria auditoria = new LoginAuditoria();
        auditoria.setLogin( usuario.getLogin() );
        auditoria.setAccion( "USUARIO MODIFICADO");
        //
        loginAuditoriaRepository.save( auditoria );
    }

}

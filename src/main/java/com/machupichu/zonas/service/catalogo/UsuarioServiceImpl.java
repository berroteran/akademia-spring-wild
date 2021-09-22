package com.machupichu.zonas.service.catalogo;

import com.machupichu.zonas.data.repository.UserRepository;
import com.machupichu.zonas.model.User;
import com.machupichu.zonas.model.auditoria.LoginAuditoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UserRepository usuarioDAO;
    @Autowired
    private LoginAuditoriaServicio loginAuditoriaServicio;



    @Transactional
    @Override
    public List<User> search(String searchCriteria) {
        return usuarioDAO.search(searchCriteria);
    }


    @Override
    public List<User> findAll() {
        return (List<User>) usuarioDAO.findAll();
    }

    @Transactional
    @Override
    public void saveUsuario(User usuario) {
        if ( usuario.getId() == null )
            loginAuditoriaServicio.usuarioCreado(usuario);
        else
            loginAuditoriaServicio.usuarioActualizado(usuario);
        usuarioDAO.save(usuario);
    }

    @Override
    public String changePassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }


}

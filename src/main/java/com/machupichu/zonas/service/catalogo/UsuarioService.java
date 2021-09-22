package com.machupichu.zonas.service.catalogo;

import com.machupichu.zonas.model.User;

import java.util.List;

public interface UsuarioService {
    List<User> search(String searchCriteria);

    List<User> findAll();

    void saveUsuario(User usuario);

    String changePassword(String password);
}

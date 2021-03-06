package com.berroteran.bmo.akademia.service.catalogo;

import com.berroteran.bmo.akademia.model.User;

import java.util.List;

public interface UsuarioService {
    List<User> search(String searchCriteria);

    List<User> findAll();

    void saveUsuario(User usuario);

    String changePassword(String password);
}

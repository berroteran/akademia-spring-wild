package com.machupichu.zonas.security;

import com.machupichu.zonas.data.repository.UserRepository;
import com.machupichu.zonas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException, NoSuchElementException {
        User currentUser;
        UserDetails user;
        try {
            currentUser = userRepository.findByLogin(login).get();

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            user = new org.springframework.security.core.userdetails.User(login, currentUser.getPassword(), grantedAuthorities);
        } catch (Exception e) {
            String msj = "No se encontró el usuario indicado.";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Iniciando sesión", msj));
            throw new UsernameNotFoundException(msj);
        }
        return user;
    }
}

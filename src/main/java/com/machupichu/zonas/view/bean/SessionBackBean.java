package com.machupichu.zonas.view.bean;

import com.machupichu.zonas.data.repository.UserRepository;
import com.machupichu.zonas.model.EstadosProcesoEnum;
import com.machupichu.zonas.model.Oficina;
import com.machupichu.zonas.model.User;
import com.machupichu.zonas.model.auditoria.LoginAuditoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Collection;

@Component
@Scope("session")
public class SessionBackBean implements Serializable {
    private final UserRepository userRepository;

    @Autowired
    public SessionBackBean(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Autowired
    private LoginAuditoriaServicio loginAuditoriaServicio;

    private String username;
    private String password;
    private User userDetails;

    @PostConstruct
    public void init() {
        ///System.out.println("guestPreferences.menuMod : " + guestPreferences.menuMod);
    }




    private Collection<? extends GrantedAuthority> getAuthorities( User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getNombre()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

    public String loginAction() {
        FacesMessage message = null;
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        DefaultSavedRequest savedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");

        try {
            System.out.println("Iniciando Sesion. Cargando información de usuario.");
            userDetails = userRepository.findByLogin(username).orElse(null);

            if (userDetails == null) throw new UsernameNotFoundException("El usuario indicado no existe.");

            System.out.println("userDeatils");
            System.out.println(userDetails);

            String passwordEncryptedFromDatabase = userDetails.getPassword();
            String passwordFromUser = password;

            //validando la clave
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            if ( !bCryptPasswordEncoder.matches( passwordFromUser, passwordEncryptedFromDatabase ) ) {
                loginAuditoriaServicio.savePasswordIncorrecta( username );
                throw new BadCredentialsException("Usuario o contraseña incorrectos");
            }

            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, passwordEncryptedFromDatabase, getAuthorities(userDetails));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            if (!userDetails.getActivo()) {
                loginAuditoriaServicio.saveCuentaDisable( username );
                throw new DisabledException("Su cuenta ha sido desabilitada");
            }
            if (userDetails.isAccountExpired()) {
                loginAuditoriaServicio.saveCuentaExpirada(username );
                throw new LockedException("su cuenta ha expirado, debe actualizar sus datos con el equipo de TI");
            }
            if (userDetails.isForceUpdatePassword() ) {
                loginAuditoriaServicio.saveUpdatePassword(username );
                throw new LockedException("Su contraseña a expirado, debe actualizarla");
            }


            loginAuditoriaServicio.saveExito(username);

            password = null;
            //TODO comentado porque está dando muchos problemas, se ajustara despues.
            /*
            if (savedRequest != null) {
                if (savedRequest.getRequestURI() != null)
                    return savedRequest.getRequestURI() + "?faces-redirect=true";
            } else {
                return "/index.xhtml?faces-redirect=true";
            }
             */
            return "/index.xhtml";

        } catch (BadCredentialsException e) {
            loginAuditoriaServicio.saveUsuarioNoexiste(username );
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales incorrectas", e.getMessage());
        } catch (DisabledException e) {
            loginAuditoriaServicio.saveUsuarioDesactivad( username );
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario ha sido desactivado", e.getMessage());
        } catch (AuthenticationException e) {
            loginAuditoriaServicio.saveErrorLoginGeneral(username );
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al autenticarse", e.getMessage());
        }

        FacesContext.getCurrentInstance().validationFailed();
        FacesContext.getCurrentInstance().addMessage("message", message);

        return "/login.xhtml?error=true";
    }

    public String logoutAction() {
        SecurityContextHolder.clearContext();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/logout";
    }

    public String getLogin() {
        return userDetails == null ? "" : userDetails.getLogin();
    }

    public String getUserName() {
        return userDetails == null ? "" : userDetails.getFirstName() + " " + userDetails.getLastName();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return userDetails.isAdmin();
    }

    public Oficina getOficina() {
        return userDetails.getOficina();
    }

    public User getUser() {
        return userDetails;
    }

    public EstadosProcesoEnum[] getEstosProces(){
        return EstadosProcesoEnum.values();
    }

}



package com.machupichu.zonas.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USUARIO")
@SequenceGenerator(name = "seqUser", sequenceName = "seqUser_id_seq", allocationSize = 1)
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUser")
    private Integer id;

    @Column(name = "LOGIN", length = 255, nullable = false, unique = true)
    private String login;
    @Column(name = "PASSWORD", length = 255, nullable = false)
    private String password;
    @Column(name = "FIRST_NAME", length = 255, nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", length = 255, nullable = false)
    private String lastName;
    private String email;

    @ColumnDefault("false")
    private boolean accountExpired;
    private boolean verified;
    private Boolean activo;
    private boolean admin;

    @ManyToOne
    @JoinColumn(name = "oficina_id")
    private Oficina oficina;


    @ColumnDefault("false")
    //@Column(name = "isDeleted", columnDefinition = "boolean default true")
    private boolean forceUpdatePassword;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Roles> roles = new HashSet<>();


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActivo() {
        return activo == null ? false : activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountNonExpired) {
        this.accountExpired = accountNonExpired;
    }


    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public boolean isForceUpdatePassword() {
        return forceUpdatePassword;
    }

    public void setForceUpdatePassword(boolean forceUpdatePassword) {
        this.forceUpdatePassword = forceUpdatePassword;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", accountExpired=" + accountExpired +
                ", verified=" + verified +
                ", activo=" + activo +
                ", admin=" + admin +
                //", oficina=" + oficina +
                ", forceUpdatePassword=" + forceUpdatePassword +
                ", roles=" + roles +
                '}';
    }
}

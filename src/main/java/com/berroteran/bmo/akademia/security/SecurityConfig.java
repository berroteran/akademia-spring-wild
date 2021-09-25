package com.berroteran.bmo.akademia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        @Autowired
        private UserDetailServiceImpl userDetailsService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // http://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/AntPathMatcher.html
            http.headers().cacheControl().disable();
            // Para evitar error al cargar archivos con el control de prime-faces Refused to display ... in a frame because it set 'X-Frame-Options' to 'deny'.
            http.headers().frameOptions().sameOrigin();
            http.csrf().disable();

            http.requestCache().
                    requestCache(new CustomRequestCache()).and().authorizeRequests()
                    .antMatchers("/javax.faces.resource/**").permitAll()
                    .antMatchers("/**/css/**").permitAll()
                    .antMatchers("/**/js/**").permitAll()
                    .antMatchers("/**/javax.faces.resource/**").permitAll()
                    .antMatchers("/**/favicon.ico").permitAll()
                    .antMatchers("/images/**").anonymous()
                    .antMatchers("/views/configuracion/**").hasAuthority("ADMIN")
                    .antMatchers("/views/security/**").hasAuthority("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                        .loginPage("/login.xhtml").permitAll()
                        .loginProcessingUrl("/authUserAction")
                        .defaultSuccessUrl("/index.xhtml")
                        .failureUrl("/login.xhtml?error=true")

                    .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/login.xhtml");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }
    }
}


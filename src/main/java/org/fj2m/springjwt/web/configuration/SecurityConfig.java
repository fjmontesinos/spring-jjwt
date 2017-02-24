package org.fj2m.springjwt.web.configuration;

import org.fj2m.springjwt.model.auth.JwtAuthFilter;
import org.fj2m.springjwt.model.auth.JwtAuthenticationEntryPoint;
import org.fj2m.springjwt.model.auth.JwtAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by javier-montesinos on 19/02/17.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthEndPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/login");

        String[] patterns = new String[] {
                "/login",
                "/bower_components/**/*",
                "/app/**/*",
                "/index.html",
                "/home.html",
                "/signin.html",
                "/jsondoc-ui.html",
                "/jsondoc"
        };
        http.authorizeRequests()
                .antMatchers(patterns)
                .permitAll()
                .antMatchers("/**/*")
                .hasAuthority("ROLE_USER")
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthEndPoint);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth)  throws Exception {
        auth.authenticationProvider(jwtAuthenticationProvider);
    }
}

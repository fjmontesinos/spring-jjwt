package org.fj2m.springjwt.web;

import org.fj2m.springjwt.model.JwtService;
import org.fj2m.springjwt.model.LoginService;
import org.fj2m.springjwt.model.domain.LoginCredentials;
import org.fj2m.springjwt.model.domain.MinimalProfile;
import org.fj2m.springjwt.model.exceptions.FailedToLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by javier-montesinos on 19/02/17.
 */
@RestController
@RequestMapping(path = "/login")
public class LoginController {

    private final LoginService loginService;
    private final JwtService jwtService;

    @SuppressWarnings("unused")
    public LoginController() {
        this(null, null);
    }

    @Autowired
    public LoginController(LoginService loginService, JwtService jwtService) {
        this.loginService = loginService;
        this.jwtService = jwtService;
    }

    @RequestMapping(path = "",
            method = POST,
            produces = APPLICATION_JSON_VALUE)
    public MinimalProfile login(@RequestBody LoginCredentials credentials,
                                HttpServletResponse response) {
        return loginService.login(credentials)
                .map(minimalProfile -> {
                    try {
                        response.setHeader("Token", jwtService.tokenFor(minimalProfile));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return minimalProfile;
                })
                .orElseThrow(() -> new FailedToLoginException(credentials.getUsername()));
    }
}

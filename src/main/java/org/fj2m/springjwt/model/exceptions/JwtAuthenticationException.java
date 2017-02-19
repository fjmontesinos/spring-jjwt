package org.fj2m.springjwt.model.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by javier-montesinos on 19/02/17.
 */
public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }
}

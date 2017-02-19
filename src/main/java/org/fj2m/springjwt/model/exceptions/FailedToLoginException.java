package org.fj2m.springjwt.model.exceptions;

import static java.lang.String.format;

/**
 * Created by javier-montesinos on 19/02/17.
 */
public class FailedToLoginException extends RuntimeException{
    public FailedToLoginException(String username) {
        super(format("Failed to login with username %s", username));
    }
}

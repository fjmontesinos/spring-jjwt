package org.fj2m.springjwt.model.exceptions;

import static java.lang.String.format;

/**
 * Created by javier-montesinos on 19/02/17.
 */
public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(String username) {
        super(format("Profile with username %s does not exist", username));
    }
}

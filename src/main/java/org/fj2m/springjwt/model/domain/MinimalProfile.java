package org.fj2m.springjwt.model.domain;

import java.net.URL;

/**
 * Created by javier-montesinos on 19/02/17.
 */
public class MinimalProfile {

    private final String username;
    private final Name name;
    private final URL thumbnail;

    public MinimalProfile(Profile profile) {
        name = profile.getName();
        username = profile.getLogin().getUsername();
        thumbnail = profile.getPicture().getThumbnail();
    }

    public String getUsername() {
        return username;
    }

    public Name getName() {
        return name;
    }

    public URL getThumbnail() {
        return thumbnail;
    }
}

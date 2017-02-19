package org.fj2m.springjwt.model.domain;

import java.io.Serializable;
import java.net.URL;

/**
 * Created by javier-montesinos on 19/02/17.
 */
public class Picture implements Serializable {

    private URL large;
    private URL medium;
    private URL thumbnail;

    public URL getLarge() {
        return large;
    }

    public void setLarge(URL large) {
        this.large = large;
    }

    public URL getMedium() {
        return medium;
    }

    public void setMedium(URL medium) {
        this.medium = medium;
    }

    public URL getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(URL thumbnail) {
        this.thumbnail = thumbnail;
    }
}

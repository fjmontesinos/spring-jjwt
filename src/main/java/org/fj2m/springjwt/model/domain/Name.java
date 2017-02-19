package org.fj2m.springjwt.model.domain;

import java.io.Serializable;

/**
 * Created by javier-montesinos on 19/02/17.
 */
public class Name implements Serializable{
    private String title;
    private String first;
    private String last;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}

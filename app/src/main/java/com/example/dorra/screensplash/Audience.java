package com.example.dorra.screensplash;

import java.sql.Date;

/**
 * Created by Tej Eddine on 24/01/2017.
 */

public class Audience {
    private String id;
    private Date date;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

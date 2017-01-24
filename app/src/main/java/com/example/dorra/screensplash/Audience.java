package com.example.dorra.screensplash;

/**
 * Created by Tej Eddine on 24/01/2017.
 */

public class Audience {
    private String id;
    private String date;
    private String type;

    public Audience(String id, String date, String type) {
        this.id = id;
        this.date = date;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package com.example.awebapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wiki {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String link;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Wiki(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public Wiki() {}

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

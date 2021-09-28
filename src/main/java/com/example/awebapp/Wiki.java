package com.example.awebapp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Wiki")
public class Wiki {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wiki_generator")
    private int id;
    @NotEmpty
    private String link;
    @NotEmpty
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

    public Wiki() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Wiki{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

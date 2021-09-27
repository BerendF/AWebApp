package com.example.awebapp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Tutorial")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tutorial_generator")
    private int id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String link;
    @Min(1)
    @Max(5)
    private double rating;
    private String notes;
    private String date;

    public Tutorial(String title, String link, double rating, String notes, String date) {
        this.title = title;
        this.link = link;
        this.rating = rating;
        this.notes = notes;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", rating=" + rating +
                ", notes='" + notes + '\'' +
                ", date=" + date +
                '}';
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public Tutorial() {
        this.date = null;
    }
}


package com.example.NotflixServer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    private String id;
    private String title;
    private String genre;
    private int rate;
    @Column(length = 1200)
    private String description;

    public Movie() {}

    public Movie(String id, String title, String genre, int rate, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rate = rate;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", rate='" + rate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

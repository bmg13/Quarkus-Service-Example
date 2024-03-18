package com.bmg13.quarkus.example.model;

import java.util.Objects;
import java.util.UUID;

public class Film {
    public UUID id;
    public String title;
    public String author;
    public int yearOfPublication;

    public Film(UUID id, String title, String author, int yearOfPublication) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return yearOfPublication == film.yearOfPublication && Objects.equals(id, film.id) && Objects.equals(title, film.title) && Objects.equals(author, film.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, yearOfPublication);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }
}

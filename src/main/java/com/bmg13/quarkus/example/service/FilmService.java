package com.bmg13.quarkus.example.service;

import com.bmg13.quarkus.example.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {

    List<Film> getAllFilms();

    Optional<Film> getFilmByTitle(String title);

    int getTotalNumberOfFilms();
}

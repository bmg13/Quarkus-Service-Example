package com.bmg13.quarkus.example.service;

import com.bmg13.quarkus.example.model.Film;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class FilmServiceImpl implements FilmService {

    // mocked data for testing purposes
    @ConfigProperty(name = "film.language", defaultValue = "English")
    private String language;

    private final List<Film> initialFilms = List.of(
            new Film(UUID.randomUUID(), "Dune Part 2", "Dennis Villenneuve", 2024),
            new Film(UUID.randomUUID(), "Lord of the Rings, The Fellowship of the Ring", "Peter Jackson", 2000),
            new Film(UUID.randomUUID(), "Harry Potter and the Philosopher's Stone", "Chris Columbus", 2001));

    @Override
    public List<Film> getAllFilms() {
        return initialFilms;
    }

    @Override
    public Optional<Film> getFilmByTitle(String title) {
        return initialFilms.stream().filter(f -> f.title().equalsIgnoreCase(title)).findFirst();
    }

    @Override
    public int getTotalNumberOfFilms() {
        return initialFilms.size();
    }
}

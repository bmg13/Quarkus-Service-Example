package com.bmg13.quarkus.example.controller;

import com.bmg13.quarkus.example.model.Film;
import com.bmg13.quarkus.example.service.FilmService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/api/films")
@Produces(MediaType.APPLICATION_JSON)
public class FilmController {

    @Inject
    private FilmService filmService;

    @GET
    public List<Film> getAllFilms() {
        return this.filmService.getAllFilms();
    }

    @GET
    @Path("/count")
    public int getTotalNumberOfFilms() {
        return this.filmService.getTotalNumberOfFilms();
    }

    @GET
    @Path("{title}")
    public Optional<Film> getFilm(@PathParam("title") String title) {
        return this.filmService.getFilmByTitle(title);
    }
}

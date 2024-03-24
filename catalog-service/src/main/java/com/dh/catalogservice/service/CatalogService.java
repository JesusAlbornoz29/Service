package com.dh.catalogservice.service;

import com.dh.catalogservice.exception.GenreNotFoundException;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;

public abstract class CatalogService {
    public Genre findByGenre(String genre) throws GenreNotFoundException {
        return null;
    }

    public Genre buscarPorGenero(String genero) throws GenreNotFoundException {
        return null;
    }

    public abstract void saveMovie(Movie movie);
}

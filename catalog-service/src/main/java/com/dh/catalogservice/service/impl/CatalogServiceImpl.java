package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.exception.GenreNotFoundException;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CatalogServiceImpl extends CatalogService {

    @Autowired
    private IMovieClient iMovieClient;

    public CatalogServiceImpl(IMovieClient iMovieClient) {
        this.iMovieClient = iMovieClient;
    }

    @Override
    public Genre findByGenre(String genre) throws GenreNotFoundException {
        ResponseEntity<List<Movie>> response = iMovieClient.getMovieByGenre(genre);
        if (response.getStatusCode().is2xxSuccessful()) {
            return new Genre(response.getBody());
        }
        throw new GenreNotFoundException("No se encontró el género: " + genre);
    }

    @Override
    public void saveMovie(Movie movie) {
        iMovieClient.saveMovie(movie);
    }
}

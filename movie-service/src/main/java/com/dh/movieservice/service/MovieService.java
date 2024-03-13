/*
    Service: Actua como un intermediario entre la capa controller y la capa de acceso a datos (data access layer)
    Encapsula la logica de negocio, orquesta operaciones, abreae la capa de acceso a datos y facilita la integracion con sistemas extrenos.
*/
package com.dh.movieservice.service;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Es una anotacion de Spring Framework, indica que la clase desempeña el rol de servicio
public class MovieService {

    private final MovieRepository movieRepository;
    // Declara una variable de instancia 'movieRespository' se utiliza para acceder a las operaciones
    // de la base de datos relacionadas con peliculas

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    // Constructor de MovieService que toma como parametro 'movieRespository' y le inyecta la dependencia de movieRepository dentro de MovieService.

    public List<Movie> findByGenre(String genre) { // findByGenre y crea una List<Movie>
        return movieRepository.findByGenre(genre);
    }

    public Movie save(Movie movie) { // save una movie
        return movieRepository.save(movie);
    }
}

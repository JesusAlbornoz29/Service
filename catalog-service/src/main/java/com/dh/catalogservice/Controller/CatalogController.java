package com.dh.catalogservice.Controller;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.client.ISerieClient;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private IMovieClient iMovieClient;

    @Autowired
    private ISerieClient iSerieClient;

    private static java.util.logging.Logger log = Logger.getLogger(CatalogController.class.getName());



    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> getCatalogByGenre(@PathVariable String genre) {
        log.info("Se encontro la siguiente lista de peliculas por genero");
        return iMovieClient.getMovieByGenre(genre);
    }

    @PostMapping("/movies/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        log.info("Se guardo la pelicula correctamente");
        return iMovieClient.saveMovie(movie);
    }

    // Series
    @GetMapping("/series")
    public List<Serie> getAllSeries() {
        log.info("Se encontro la siguiente lista de Series");
        return iSerieClient.getAll();
    }

    @GetMapping("/series/{genre}")
    public List<Serie> getSeriesByGenre(@PathVariable String genre) {
        log.info("Se encontro la siguiente lista de Series por genero");
        return iSerieClient.getSerieByGenre(genre);
    }

    @PostMapping("/series/save")
    public String createSerie(@RequestBody Serie serie) {
        log.info("Se guardo la serie correctamente");
        return iSerieClient.crearSerie(serie);
    }

}

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

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private IMovieClient iMovieClient;

    @Autowired
    private ISerieClient iSerieClient;

    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> getCatalogByGenre(@PathVariable String genre) {
        return iMovieClient.getMovieByGenre(genre);
    }

    @PostMapping("/movies/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return iMovieClient.saveMovie(movie);
    }

    // Series
    @GetMapping("/series")
    public List<Serie> getAllSeries() {
        return iSerieClient.getAll();
    }

    @GetMapping("/series/{genre}")
    public List<Serie> getSeriesByGenre(@PathVariable String genre) {
        return iSerieClient.getSerieByGenre(genre);
    }

    @PostMapping("/series/save")
    public String createSerie(@RequestBody Serie serie) {
        return iSerieClient.crearSerie(serie);
    }

}

package com.dh.catalogservice.client;

import com.dh.catalogservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "movie-service")
public interface IMovieClient {

   // @RequestMapping(method = RequestMethod.GET, value = "/movies/{genre}")
    // List<IMovieClient> getMovieByGenre(@PathVariable String genre);

     @GetMapping("movies/{genre}")
        ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre);

     @PostMapping("/movies/save")
        ResponseEntity<Movie> saveMovie(@RequestBody Movie movie);
}

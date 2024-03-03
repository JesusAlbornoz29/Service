package com.dh.catalogservice.client;

import com.dh.catalogservice.configuration.LoadBalancerConfiguration;
import com.dh.catalogservice.model.Movie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "movie-service")
@LoadBalancerClient(name = "movie-service",configuration = LoadBalancerConfiguration.class)
public interface IMovieClient {

     @GetMapping("movies/{genre}")
        ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre);

     @PostMapping("/movies/save")
        ResponseEntity<Movie> saveMovie(@RequestBody Movie movie);

}


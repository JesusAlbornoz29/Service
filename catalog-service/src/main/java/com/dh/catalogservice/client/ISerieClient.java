package com.dh.catalogservice.client;

import com.dh.catalogservice.configuration.LoadBalancerConfiguration;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "serie-service")
@LoadBalancerClient(name = "serie",configuration = LoadBalancerConfiguration.class)
public interface ISerieClient {

    @GetMapping("series")
    List<Serie> getAll();
    @GetMapping("series/{genre}")
    List<Serie> getSerieByGenre(@PathVariable String genre);

    @PostMapping("/series/save")
    @ResponseStatus(HttpStatus.CREATED)
    String crearSerie(@RequestBody Serie serie);

}

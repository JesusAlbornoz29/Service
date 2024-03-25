package com.dh.serieservice.controller;

import com.dh.serieservice.model.Serie;
import com.dh.serieservice.service.SerieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author vaninagodoy
 */

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    private static java.util.logging.Logger log = Logger.getLogger(SerieController.class.getName());

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public List<Serie> getAll() {
        log.info("Se encontraron estas series");
        return serieService.getAll();
    }

    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        log.info("Se encontraron estas series por genero ");
        return serieService.getSeriesBygGenre(genre);
    }

    @PostMapping ("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Serie serie) {
        log.info("Se guardo la serie correctamente");
        serieService.create(serie);
        return serie.getId();
    }
}

package com.dh.catalogservice.service;

import com.dh.catalogservice.client.ISerieClient;
import com.dh.catalogservice.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {
    private final ISerieClient serieClient;

    @Autowired
    public SerieService(ISerieClient serieClient) {
        this.serieClient = serieClient;
    }

    public List<Serie> getSeriesByGenre(String genre) {
        return serieClient.getSerieByGenre(genre);
    }

    public List<Serie> getAllSeries() {
        return serieClient.getAll();
    }
}

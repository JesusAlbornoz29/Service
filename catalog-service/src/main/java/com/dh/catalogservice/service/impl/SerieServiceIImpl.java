package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.client.ISerieClient;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SerieServiceIImpl extends SerieService {

    @Autowired
    private ISerieClient iSerieClient;

    public SerieServiceIImpl(ISerieClient serieClient) {
        super(serieClient);
    }

    @Override
    public List<Serie> getSeriesByGenre(String genre) {
        return iSerieClient.getSerieByGenre(genre);
    }
    @Override
    public List<Serie> getAllSeries() {
        return iSerieClient.getAll();
    }


}

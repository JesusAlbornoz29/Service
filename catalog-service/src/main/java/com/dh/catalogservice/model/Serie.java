package com.dh.catalogservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Serie  {

    private String id;
    private String name;
    private String genre;
    private List<Season> seasons = new ArrayList<>();

    @Data
    public static class Season {
        private Integer seasonNumber;
        private List<Chapter> chapters = new ArrayList<>();
    }

    @Data
    public static class Chapter {
        private String name;
        private Integer number;
        private String urlStream;
    }

}

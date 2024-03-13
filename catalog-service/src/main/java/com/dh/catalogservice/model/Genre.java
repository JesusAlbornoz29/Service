package com.dh.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data // @Data viene del Project Lombok genera automaticamente metodos 'toString()','equals()','hashCode()','getters y setters'
@AllArgsConstructor  // @AllArgsConstructor viene de Lombok genera automaticamente un constructor que toma como argumetno todos los campos de una clase
@RequiredArgsConstructor // @RequiredArgsConstructor viene de Lombok en particular esta anotacion es util para generar constructores que inicualizan campos finales y marcados con '@NotNull'
public class Genre {
    private List<Movie> movies;
}

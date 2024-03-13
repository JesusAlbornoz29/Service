/*
Esta clase se crea para poder obtener los datos traidos desde el el microservicio de movie y su clase movie
*/


package com.dh.catalogservice.model;

public record Movie (Long id, String name, String genre, String urlStream){
}

/*
Esta carpeta Service/impl> Contiene las implementaciones concretas de las interfaces destinadas en la carpeta de servicio
Aqui se encuentra la logica ya que en /Service/CatalogoService es una clase abstraca la logica se define aqui
*/

package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.exception.GenreNotFoundException;
import com.dh.catalogservice.model.Genre;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.CatalogService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CatalogServiceImpl extends CatalogService { // Aqui practicamente decimos que vamos a heredar los metodos definidos en CatalogoService para darles logica

    @Autowired // @Autowired viene de Spring Framework se utiliza para facilitar la inyección de dependencias y reducir la necesidad de crear manualmente instancias de clases dependientes en tu código
    private IMovieClient iMovieClient;

    public CatalogServiceImpl(IMovieClient iMovieClient) {
        this.iMovieClient = iMovieClient;
    } // Esto es el constructor de CatalogServiceImpl que toma una instancia de IMovieClient, esto quire decir que realizara algunas operaciones relacionada con peliculas a travez de la inyeccion de dependencia

    @Override //se utiliza para asegurar que el metodo sobrescribe correctamente el metodo con el mismo nombre de su calse base
    @CircuitBreaker(name = "movie", fallbackMethod = "emptyGenreFallbackMethod")
    public Genre findByGenre(String genre) throws GenreNotFoundException {
        ResponseEntity<List<Movie>> response = iMovieClient.getMovieByGenre(genre);
        if (response.getStatusCode().is2xxSuccessful()) {
            return new Genre(response.getBody());
        }
        throw new GenreNotFoundException("No se encontró el género: " + genre);
    }

<<<<<<< HEAD

=======
    private Genre emptyGenreFallbackMethod(CallNotPermittedException a){
        return new Genre();
    }
>>>>>>> a80d277c8d412f959ad9475aa4bfbf34325d2547

    /*
    Entendamos el codigo de arriba, este método findByGenre() busca películas por género utilizando un cliente de películas (iMovieClient).
    Si la respuesta del servidor es exitosa, crea un objeto Genre con la lista de películas obtenidas y lo devuelve.
    Si la respuesta no es exitosa, lanza una excepción GenreNotFoundException.
    La anotación @Override garantiza que este método sobrescribe correctamente un método con el mismo nombre de su clase base o interfaz.
    */

    @Override
    public void saveMovie(Movie movie) {
        iMovieClient.saveMovie(movie);
    }

}

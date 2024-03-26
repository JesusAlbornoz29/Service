/* Controller: Contine clases que manejan la
solicitudes del cliente
(Se refiere a las peticiones que un cliente (NavegadorWeb, AppMovile, etc) hace a un servidor para obtener datos o realizar acciones
y
coordinan la logica de la aplicacion
(Se refiere a la gestion de las operaciones y procesos que la app debe realizar en respuesta a estas solicitudes)
.

EJ: En una aplicacion web de comercio electronico, cuando un usuario hace clic en el boton "Agregar al carrito", el navegador envia una solicitud al servidor.
El controlador correspondiente recibe esta solcitud y puede coordinar la logica de la applicacion
necesaria para agregar el articulo al carrito del usuario. Esto puede implicar verificar la disponibilidad del producto, actualizar la cantidad en el carrito,
calcular el total, etc...
*/

package com.dh.movieservice.controller;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.queue.MovieSender;
import com.dh.movieservice.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController // En lugar de vistas, devuelve datos serializados (JSON O XML) directamente a la respuesta HTTP.
@RequestMapping("/movies") // Todas las solicitudes seran dirigidas a '/movies'
public class MovieController {
    private final MovieService movieService;
    // declaramos movieService que proporciona los servicios relacionados con las peliculas, como buscar peliculas por genero o guardar una nueva pelicula.
    private static java.util.logging.Logger log = Logger.getLogger(MovieController.class.getName());

    private final MovieSender senderMovie;


    public MovieController(MovieService movieService, MovieSender senderMovie) {
        this.movieService = movieService;
        this.senderMovie = senderMovie;
    }
    // Creamos el constructor MovieController y le inyectamos la dependencia de MovieService para que el controlador interactue con la capa Service

    @GetMapping("/{genre}") // Indica que Se manejaran peticiones GET
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) { //@PathVariable extrae lo obtenido en @GetMapping("/{genre}") y lo guarda en String genre
        log.info("Se encontro la lista de genero");
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
        // ResponseEntity> los datos findByGenere(genre) se envuelven dentro de un 'ResponseEntity'
        // .ok() Indica que la solicitud se completo con exito
        // body(). Establece el cuerpo de la respuesta contine la lista de peliculas encotradas por genero
    }

    @PostMapping("/save") // Indica que se manejaran peticiones POST
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        log.info("Se creo la pelicula correctamente");
        senderMovie.send(movie);
        return ResponseEntity.ok().body(movieService.save(movie));

    }
}

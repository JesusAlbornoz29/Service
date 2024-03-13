/*
    Repository> En Java en el conteto de Spring Framework y JPA (Java Persistence API),
    define la capa de acceso a datos de la aplicacion. Se utiliza para interactuar con la base de datos  o cualquier otra fuente de datos.
*/

package com.dh.movieservice.repository;

import com.dh.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Spring Data JPA marca la interfaz como un componente de repositorio
public interface MovieRepository extends JpaRepository<Movie, Long> // JpaRespository es una interfaz proporcionada por Spring Data JPA que proporciona
    // metodos CRUD basicos
{
    List<Movie> findByGenre(String genre);
}

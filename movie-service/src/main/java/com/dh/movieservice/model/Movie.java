// Modelo o Entidad (Model or Entity)

package com.dh.movieservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data // @Data viene del Project Lombok genera automaticamente metodos 'toString()','equals()','hashCode()','getters y setters'
@Entity // @Entity  viene de JPA (Java Persistence API) marca la clase como una entidad.
@AllArgsConstructor // @AllArgsConstructor viene de Lombok genera automaticamente un constructor que toma como argumetno todos los campos de una clase
@NoArgsConstructor // @NoArgsConstructor viene de Lombok genera automaticamente un constructor sin argumentos
public class Movie implements Serializable { // Serializable esta interfaz es necesaria en algunos contextos, como al enviar objetos a traves de la red o al alamacenarlos en archivos.

    private static final long serialVersionUID = 1L;
    // Esta linea declara un campo que es un identificador unico para la versinon serializada de la clase. Se utiliza para asegurar que la version serializada de la clase sea compatible con su version deserializada.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Aqui especificamos como se generan los valores para la clave primaria.

    private Long id;

    private String name;

    private String genre;

    private String urlStream;

}
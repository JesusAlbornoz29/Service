Especialización Back End I
 Examen parcial
 Llegamos a la evaluación parcial donde pondremos en práctica todos los conocimientos
 vistos hasta el momento, tanto en clase como enPlayground.
 El parcial deberá ser resuelto en equipos de dos personas, para ello uno de los integrantes
 deberá crear un repositorio público que contendrá las configuraciones centralizadas del
 proyecto, mientras que el otro integrante deberá crear un repositorio privado que contendrá
 toda la estructura del proyecto, además deberá dar acceso al mismo, a su compañero y al
 profesor.
 El profesor pondrá a disposición de los alumnos un repositorio que contendrá los
 microservicios con los que se deberá desarrollar el proyecto, los alumnos deberán clonar
 dicho repositorio para poder resolver el examen. Estos microservicios deben estar
 contenidos en el repositorio privado de cada equipo al comenzar a trabajar.
 A continuación se deberán crear ramas para cada tarea a realizar, los nombres de las ramas
 debenserlo másdescriptivos posibles.
 Los integrantes del equipo serán los responsables de realizar los pull request.
 El día de entrega será informado por el profesor y será la fecha límite hasta la cual se podrán
 realizar cambios en los repositorios pertenecientes al examen y a las configuraciones
 centralizadas.
 1
Adicionalmente para aprobar
 Cadaintegrantedeberáalmenos:----
 configurar uno delos microservicios para su autodescubrimiento con Eureka
 centralizar la configuración de uno de los microservicios
 realizar la comunicación con feign o realizar el balanceo de carga
 realizar el proyecto Gateway o realizar el ruteo
 Recibirán la nota vía mail en el transcurso de una semana. ¡Éxitos!
 Consigna
 A partir de la siguiente arquitectura de microservicios, te pedimos implementar la misma
 utilizando Spring Cloud.
 2
movie-service
 Es una API REST que nos permite crear y consultar las películas por género. El endpoint
 deberá ser: /movies/{genre}. Cada película tiene como atributo:
 ● id
 ● name
 ● genre
 ● urlStream
 catalog-service
 API REST que nos permite buscar en el catálogo por género y también crear películas.. El
 endpoint deberá ser:/catalog/{genre}.
 La respuesta tiene la siguiente estructura:
 ● genre
 ○ movies
 ■ id
 ■ name
 ■ genre
 ■ urlStream
 Para resolver la consigna contarán con los microservicios movie y catalog. Deberán
 configurar Eureka Server para el autodescubrimiento de los microservicios, utilizando los
 nombres:
 3
● movie-service
 ● catalog-service
 A su vez, les pedimos crear el proyecto Gateway y configurar el ruteo para el microservicio
 quecorresponda.
 También deberán agregar y configurar el Config Server para obtener la configuración desde
 unrepositorio Git.
 Deberán utilizar Feign para comunicar los microservicios y obtener desde catálogo las
 películas filtradas por género, como así también para crearlas.
 Además deberán realizar el Balanceo de carga conLoadBalanceyadjuntarscreenshotsdel
 resultado en Postman.
 Test
 Agregar una película de género “Acción” en el microservicio movie y consultar el catálogo
 mediante request al endpoint /catalog/{genre} (catalog-service). Adjuntar screenshot de
 este test realizado en Postman.

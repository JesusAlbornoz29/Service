<h1>Especialización Back End I - Examen Parcial</h1>
<p>Llegamos a la evaluación parcial donde pondremos en práctica todos los conocimientos vistos hasta el momento, tanto en clase como en Playground.</p>
<p>El parcial deberá ser resuelto en equipos de dos personas, para ello uno de los integrantes deberá crear un repositorio público que contendrá las configuraciones centralizadas del proyecto, mientras que el otro integrante deberá crear un repositorio privado que contendrá toda la estructura del proyecto, además deberá dar acceso al mismo, a su compañero y al profesor.</p>
<p>El profesor pondrá a disposición de los alumnos un repositorio que contendrá los microservicios con los que se deberá desarrollar el proyecto, los alumnos deberán clonar dicho repositorio para poder resolver el examen. Estos microservicios deben estar contenidos en el repositorio privado de cada equipo al comenzar a trabajar.</p>
<p>A continuación se deberán crear ramas para cada tarea a realizar, los nombres de las ramas deben ser lo más descriptivos posibles.</p>
<p>Los integrantes del equipo serán los responsables de realizar los pull request.</p>
<p>El día de entrega será informado por el profesor y será la fecha límite hasta la cual se podrán realizar cambios en los repositorios pertenecientes al examen y a las configuraciones centralizadas.</p>
<div>
  <h2>Adicionalmente para aprobar</h2>
  <p>Cada integrante deberá al menos:</p>
  <ul>
    <li>Configurar uno de los microservicios para su autodescubrimiento con Eureka.</li>
    <li>Centralizar la configuración de uno de los microservicios.</li>
    <li>Realizar la comunicación con Feign o realizar el balanceo de carga.</li>
    <li>Realizar el proyecto Gateway o realizar el ruteo.</li>
  </ul>
  <p>Recibirán la nota vía mail en el transcurso de una semana. ¡Éxitos!</p>
</div>
<div>
  <h2>Consigna</h2>
  <p>A partir de la siguiente arquitectura de microservicios, te pedimos implementar la misma utilizando Spring Cloud.</p>
  <h3>movie-service</h3>
  <p>Es una API REST que nos permite crear y consultar las películas por género. El endpoint deberá ser: /movies/{genre}. Cada película tiene como atributo:</p>
  <ul>
    <li>id</li>
    <li>name</li>
    <li>genre</li>
    <li>urlStream</li>
  </ul>
  <h3>catalog-service</h3>
  <p>API REST que nos permite buscar en el catálogo por género y también crear películas. El endpoint deberá ser: /catalog/{genre}.</p>
  <p>La respuesta tiene la siguiente estructura:</p>
  <ul>
    <li>genre</li>
    <ul>
      <li>movies</li>
      <ul>
        <li>id</li>
        <li>name</li>
        <li>genre</li>
        <li>urlStream</li>
      </ul>
    </ul>
  </ul>
  <p>Para resolver la consigna contarán con los microservicios movie y catalog. Deberán configurar Eureka Server para el autodescubrimiento de los microservicios, utilizando los nombres:</p>
  <ul>
    <li>movie-service</li>
    <li>catalog-service</li>
  </ul>
  <p>A su vez, les pedimos crear el proyecto Gateway y configurar el ruteo para el microservicio que corresponda.</p>
  <p>También deberán agregar y configurar el Config Server para obtener la configuración desde un repositorio Git.</p>
  <p>Deberán utilizar Feign para comunicar los microservicios y obtener desde catálogo las películas filtradas por género, como así también para crearlas.</p>
  <p>Además deberán realizar el Balanceo de carga con LoadBalance y adjuntar screenshots del resultado en Postman.</p>
</div>
<div>
  <h2>Test</h2>
  <p>Agregar una película de género “Acción” en el microservicio movie y consultar el catálogo mediante request al endpoint /catalog/{genre} (catalog-service). Adjuntar screenshot de este test realizado en Postman.</p>
</div>


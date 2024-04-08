
<h1>Spring Cloud - Sistema de Microservicios</h1>
<p align="center" >
  <img alt="Diagrama" width="600" height="480" src="https://github.com/JesusAlbornoz29/Service/blob/main/imagen_2024-04-08_092035938.png" style="vertical-align: middle;">
</p>
  <h2>Proyecto</h2>
    <p>A partir de la siguiente arquitectura de microservicios, te pedimos implementar la misma utilizando Spring Cloud.</p>
    <p>El proyecto consiste de tres microservicios: Movie, Serie y Catalog.</p>
    <p>Catalog es una API REST que nos permite buscar por género, tanto películas como series. Además desde el microservicio catalog se deberán poder guardar películas y series.</p>
    <p>La comunicación entre microservicio para crear películas debe realizarse con Feign. Al guardar una película, la misma se persistirá en su base de datos (movie-service).</p>
    <p>Cuando se persiste una película en su base de datos, adicionalmente se debe enviar un mensaje a través de una cola de RabbitMQ a catalog-service, quien lo persistirá en su base de datos no relacional MongoDB. Lo mismo deberá ocurrir con las series (serie-          service).</p>
    <p>Cuando Catalog busca por género, lo hace directamente en su base de datos no relacional MongoDB.</p>
    </br>
    <p>Diagrama base de los microservicios:</p>
  <h3>movie-service</h3>
    <p>El microservicio gestiona las operaciones sobre las películas. Cada película tiene como atributo:</p>
      <ul>
        <li>id</li>
        <li>name</li>
        <li>genre</li>
        <li>urlStream</li>
      </ul>
  <h3>serie-service</h3>
    <p>El microservicio gestiona las operaciones sobre las series. Cada serie tiene como atributos:</p>
      <ul>
        <li>id</li>
        <li>name</li>
        <li>genre</li>
        <li>seasons</li>
          <ul>
            <li>id</li>
            <li>seasoNumber</li>
            <li>chapters</li>
              <ul>
                <li>id</li>
                <li>name</li>
                <li>number</li>
                <li>urlStream</li>
              </ul>
          </ul>
      </ul>
  <h3>catalog-service</h3>
    <p>Los microservicios de película y serie deben ser invocados cada vez que se carga una nueva película o serie y se debe persistir la información que proporcionan ambos microservicios en una base de datos no relacional de MongoDB con la siguiente estructura:      </p>
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
        <ul>
          <li>series</li>
          <ul>
            <li>id</li>
            <li>name</li>
            <li>genre</li>
            <li>seasons</li>
              <ul>
                <li>id</li>
                <li>seasonNumber</li>
                <li>chapters</li>
                  <ul>
                    <li>id</li>
                    <li>name</li>
                    <li>number</li>
                    <li>urlStream</li>
                  </ul>
              </ul>
          </ul>
        </ul>
    </ul>
  </ul>





  <h2>Tareas</h2>
  <ul>
    <li>Configurar los microservicios para su autodescubrimiento con Eureka.</li>
    <li>Centralizar la configuración de los microservicios.</li>
    <li>Realizar la comunicación con Feign.</li>
    <li>Realizar el balanceo de carga</li>
    <li>Realizar el proyecto Gateway o realizar el ruteo.</li>
    <li>Comunicacion con RabbitMQ</li>
  </ul>
  <ul>
    <h3>serie-service</h3>
    <ul>
      <li>Configurar	el	nuevo	servicio	para	su	auto	descubrimiento	utilizando	el	nombre: serie-service. </li>
      <li>Centralizar la configuración de serie-service.</li>
      <li>Realizar la comunicación con Feign de serie-service y catalog-service para persistir en la base de datos de serie, cada serie creada. </li>
      <li>Agregar RabbitMQ y enviar un mensaje en el momento que se agregue una nueva serie. </li>
    </ul>
    <h3>movie-service</h3>
    <ul>
      <li>Agregar RabbitMQ y enviar un mensaje en el momento que se agregue una nueva película. </li>
    </ul>
    <h3>catalog-service</h3>
    <ul>
      <li>Modificar la consulta por género, que ahora será directamente a su base de datos no relacional MongoDB. </li>
      <li>Actualizar catalog utilizando Feign para comunicarlo con el microservicio serie-service, y obtener desde catálogo las series filtradas por género, como así también utilizar la Feign para crearlas. </li>
      <li>Agregar RabbitMQ y escuchar los mensajes que envían movie-service y serie-service. En caso de recibir un mensaje de algún servicio, actualizar el listado correspondiente, ya sea de las películas o las series. </li>
    </ul>
    </br>
    <h3>Spring Cloud: traceo utilizando Zipkin</h3>
    <ul>
      <li>Configurar Zipkin en todos los microservicios para visualizar la trazabilidad.</li>
    </ul>
    <h3>Persistencia - Resilence4j</h3>
    <ul>
      <li>Se debe seleccionar uno de los servicios (preferentemente el que consideres que será más utilizado) y adaptarlo para que el mismo sea tolerante a fallos. </li>
    </ul>
  </ul>
</div>

<div>



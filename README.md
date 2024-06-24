# bs-colegio-management-v1

_Repositorio de Proyecto de colegio (incluye microservicios de alumnos, cursos y profesores)_



## Getting Started

# School-Microservices

Este proyecto utiliza Java 17 con Spring Boot 3.3.0 y está compuesto por tres microservicios:

1. **Servicio Cursos**: Un microservicio autónomo que realiza sus propias tareas.
2. **Servicio Alumnos**: Un microservicio que consume el Servicio Cursos a través de HTTP.
3. **Servicio de Mensajería (query-logs)**: Un microservicio que recibe y registra en consola las transacciones de los servicios anteriores mediante ActiveMQ.

## Requisitos

- Java 17
- Springboot
- Maven
- ActiveMQ
- Postgres

## Configuración

Para la correcta configuración del servicio, se recomienda usar las configuraciones establecidas en los archivos `application.properties` de cada componente.

### Servicio Cursos

Este microservicio funciona de forma autónoma y no requiere configuraciones adicionales.

### Servicio Alumnos

Este microservicio realiza llamadas HTTP al Servicio Car.

### Servicio de Mensajería (query-logs)

Este microservicio utiliza ActiveMQ para recibir mensajes sobre el estado de las peticiones y las muestra en consola. Configura las propiedades de ActiveMQ en el `application.properties`:

```properties
# Ejemplo de configuración
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin
```

## Ejecución

1. Clona el repositorio:
   ```sh
   git clone https://github.com/marvelnano/bs-colegio-management-v1.git
   ```
2. Navega al directorio del proyecto:
   ```sh
   cd bs-user-management-v1
   ```
   
3. Ejecuta el sql en tu base de datos(cursos):

   ```sh
   psql -U root -d cursos -f Cursos.sql
   ```

4. Compila y empaqueta los microservicios con Maven:
   ```sh
   mvn clean install
   ```

5. Ejecuta cada microservicio:
   ```sh
   # Servicio Cursos
   java -jar springboot-test-cursos/target/springboot-test-cursos-0.0.1-SNAPSHOT.jar

   # Servicio Alumnos
   java -jar springboot-test-alumnos/target/springboot-test-alumnos-0.0.1-SNAPSHOT.jar

   # Servicio de Mensajería
   java -jar springboot-test-query-log/target/springboot-test-query-log-0.0.1-SNAPSHOT.jar
   ```

## Notas Adicionales

- Asegúrate de que ActiveMQ esté corriendo antes de iniciar el Servicio de Mensajería.
- Revisa los logs de cada servicio para verificar que se están comunicando correctamente.
- El repositorio incluye una coleccion de Postman para falicitar la prueba de los servicios `Concessionaire.postman_collection`.

## Ejecutando las pruebas ⚙️

_Abrir el repositorio(proyecto) en VSCode o Spring Tool Suite 4_

### Realizar las pruebas de forma local 🔩

* En la consola del proyecto en VSCode entrar a cada proyecto y escribir:
```
mvnw spring-boot:run
```

* En la consola del proyecto en VSCode linux entrar a cada proyecto y escribir:
```
./mvnw spring-boot:run
```

* En Spring Tool Suite 4 ir a Boot Dashboard, desglosar local, seleccionar el proyecto, click derecho y start:

### Abrir un cmd en la ubicación del Spring Tool Suite y escribir:

* para saber la versión de java que tenemos:
```
java -version
```

* Para poder usar lombok en el IDE(para eso debemos de tener el archivo lombok.jar dentro de la ruta del STS):
```
java -jar lombok.jar
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#using.devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


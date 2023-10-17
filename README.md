# Aplicacion Web para la administración de turnos.
Aplicación web para la gestion de turnos de un consultorio psicologico dentro de un sanatorio. 
Utilizando Springboot como framework para el backend con Java, y plantillas Thymeleaf para el lado del front-end utilizando
Server Side Rendering (SSR).
### Tecnologias Utilizadas:
- Springboot Starter Web
- Spring JPA.
- Thymeleaf
- Validation
- Docker-Compose
- PostgresSQL Driver
- Lombock

Esta aplicación nace como parte de un proyecto integrador de la materia Programación Orientada a Objetos II, de la carrera
Analista en Sistemas.

Para poder compilar la aplicación se debe utilizar el siguiente comando dentro del directorio general:
~~~bash
mvn clean install
~~~

Y para correr la aplicación:
~~~bash
java -jar webbapp-consultorio
~~~

Dentro de la carpeta general se puede acceder a la documentación mediante el Javadoc: _javadoc/index.html_
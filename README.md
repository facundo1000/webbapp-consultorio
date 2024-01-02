# Aplicacion Web para la administración de turnos.
Aplicación web para la gestion de turnos de un consultorio psicologico dentro de un sanatorio. 
Utilizando Springboot como framework para el backend con Java, y plantillas Thymeleaf para el lado del front-end utilizando
Server Side Rendering (SSR).
### Tecnologias Utilizadas:
- Springboot Starter Web
- Spring JPA.
- Thymeleaf
- Validation
- H2 Database
- Lombock

Acceso a la aplicación: [consiltorio](https://consultorio-oey7.onrender.com)

Esta aplicación nace como parte de un proyecto integrador de la materia Programación Orientada a Objetos II, de la carrera
Analista en Sistemas.

Para poder compilar la aplicación se debe utilizar el siguiente comando dentro del directorio general:
~~~bash
mvn clean install
~~~

Y para correr la aplicación se debe acceder a la carpeta "target" y correr el siguiente codigo por consola:
~~~bash
java -jar webbapp-consultorio
~~~

Para acceder a la base de datos H2 se puede acceder mediante el servidor ``localhost:8080/h2``

Dentro de la carpeta general se puede acceder a la documentación mediante el Javadoc: _javadoc/index.html_

### Accesos a los diferentes enpoints

- Lista de sesiones: ``http://localhost:8080/``
- Lista de pacientes: ``http://localhost:8080/lista-pacientes``
- Lista de psicologos: ``http://localhost:8080/lista-psicologos``
- Lista de secretarios: ``http://localhost:8080/listar-secretario``

# Especificacion de Requisitos de Software

## Enunciado del Problema

Escriban algunas oraciones que describan el problema que están tratando de resolver, es decir, justifiquen por qué se necesita este software.

- Se requiere un software para la gestión de sesiones de un consultorio psicológico para facilitar la gestión de los mismos, ya que, actualmente se maneja el proceso a mano alzada para documentar todo lo necesario. 
- Manejar la información de forma más simplificada, y al mismo tiempo de manera unificada.

## Clientes Potenciales

¿Quienes están afectados por este problema y se benefician de la solución propuesta? Es decir, los usuarios potenciales del software que está por construir.

Beneficiará a pequeños consultorios psicólogicos o
profesionales en el area de psicólogia, que desean contar con
un software que ayude a la gestion de su establecimiento.

## Solución Propuesta

Escriban alguna oraciones que describan como la solución de software resolverá el problema descrito anteriormente.

- **Reducción de papel**: El software permitirá almacenar digitalmente la
información de los pacientes, las sesiones, informes, historia
clínica y de los profesionales a cargo.
- **Seguridad**: Respaldará toda la información contenida en la
organización, además estará sujeto a las leyes de confidencialidad, para que la información no pueda ser vista
por personas ajenas al establecimiento.
- **Gestion**: Facilitará la gestión de los pacientes y las sesiones de
cada uno, como así también los informes o la generación
de historias clínicas, inclusive la derivación de pacientes. 

## Requisitos

Enumera los requisitos funcionales que debe tener el software para resolver el problema mencionado anteriormente. Es útil tratar de agrupar los requisitos en los que son esenciales deben estar y los que no son esenciales sería bueno que estén.

- **Registrar pacientes**: El secretario debe poder registrar pacientes en el software.

- **Modificar paciente**: El psicólogo o secretario debe poder modificar un paciente registrado en el sistema.

- **Eliminar paciente**:  El psicólogo o secretario debe poder eliminar un paciente del sistema.

- **Listar pacientes**: El psicólogo o secretario debe poder listar todos los pacientes registrados.

- **Registrar Psicólogo**: El sistema debe poder registrar psicólogos en el sistema.

- **Modificar Psicólogo**: El psicólogo debe poder modificar sus datos registrados en el sistema.

- **Eliminar Psicólogo**:  El sistema debe poder eliminar un psicólogo del sistema.

- **Listar Psicólogos**: El sistema debe poder listar a todos los psicólogos registrados.

- **Registrar Secretario**: El sistema debe permitir el registro de un nuevo secretario.

- **Modificar Secretario**: El sistema debe permitir la modificación de la información de un secretario previamente registrado.

- **Eliminar Secretario**: El sistema debe permitir la eliminación de un secretario previamente registrado. 

- **Listar Secretarios**: El sistema debe permitir listar todos los secretarios.

- **Registrar sesión**: El sistema debe permitir registrar una nueva sesión.

- **Modificar sesión**: El sistema debe permitir modificar una sesión registrada.

- **Cancelar sesión**: El sistema debe permitir cancelar una nueva sesión registrada.

- **Listar sesiones**: El sistema debe poder listar todas las sesiones registradas.

- **Generar historia clínica**: El psicólogo debe poder generar una nueva historia clínica y asociarla a un paciente.

- **Buscar historia clínica**: Permitir la búsqueda sencilla de una historia clínica particular.

- **Listar historias clínicas**: Permitir la visualización de todas las historias clínicas.

- **Registrar informe de sesión**: El psicólogo debe poder registrar la información recaudada durante una sesión.

- **Consultar informe de sesión**: El psicólogo debe poder ver un informe de sesión en particular para su posterior análisis.

- **Derivar paciente**: El psicólogo debe poder generar un documento de derivación, el cual incluirá los informes de sesión asociados al mismo.

- **Incluir inicio de sesión**: El sistema debe incluir un apartado que permita el inicio de sesión mediante roles. (NO ES PRIORIDAD)

## Arquitectura de Software

¿Será esta una aplicación web / de escritorio / móvil todas o algún otro tipo?¿Se ajustaría a la arquitectura de software Cliente-Servidor? ¿Qué lenguajes de programación, framework, bases de datos,... se utilizarán para desarrollar e implementar el software?

### Aplicación Web de tipo cliente - servidor

La arquitectura cliente-servidor es ideal para aplicaciones web que
necesitan escalabilidad, seguridad y un mantenimiento centralizado. Esto se debe a que separa responsabilidades, facilita la gestión
de actualizaciones y ofrece un alto nivel de seguridad.

### Framework: Springboot

Spring Boot agiliza el desarrollo de aplicaciones Java al ofrecer
herramientas y características que simplifican la configuración, la
creación de aplicaciones web y la gestión de dependencias, lo que
permite que los desarrolladores se enfoquen en construir la aplicación
en lugar de preocuparse por los pormenores de la configuración y la
infraestructura.

### Base de Datos: H2 

H2 es un sistema administrador de bases de datos relacionales programado en Java. Puede ser incorporado en aplicaciones Java o ejecutarse de modo cliente-servidor.

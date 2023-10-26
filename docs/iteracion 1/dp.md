# Trabajo en Equipo

El líder del equipo en esta iteración será Facundo Martinez. 
El trabajo que realizará cada integrante es el siguiente:


- Gelabert, Andre: Desarrollo del front-end y backend para la clase sesión.
- Pavon, Gabriel: Analisis y desarrollo.
- Martinez, Facundo: desarrollo backend para las clases persona, paciente y psicólogo.

# Diseño OO

### Diagrama de Clases
![diagrama](/img/poo2.jpg)



# Wireframe y Caso de Uso

### Vista de Registro de Pacientes
![vista](/img/poo2_3.jpg)

**Caso de uso**: Registrar Paciente

**Descripción**: El usuario desea registrar un nuevo paciente al sistema.

**Precondición**:

**Postcondición**: El paciente debe quedar registrado.

**Flujo Tipico de Eventos**

Actor |                                                                                                                            Sistema                                                                                                                             |
:----------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
   Este caso de Uso comienza cuando el usuario hace clic sobre el apartado “Pacientes”   |                                                                                                                                                                                    
   ----   | El sistema muestra un formulario en la sección “Registrar Nuevo Paciente” con los siguientes campos:<br/>- Tipo<br/>- Número<br/> - Nombre<br/> - Apellido<br/> -Fecha de Nac.<br/> - Sexo<br/> Ocupación<br/> - Estado Civil<br/> - Dirección<br/> - Teléfono |
     El usuario selecciona el tipo de documento del paciente (Tipo)       |        |
      El usuario ingresa el identificador del paciente (Número)      |         |
            |        | El sistema verifica que el ID (DNI) del paciente cargado no exista.
        |   El usuario completa los campos con los datos del paciente.    |
    |           | El sistema verifica si todos los datos fueron ingresados correctamente.
     El usuario hace clic sobre el botón “Agregar Paciente”   |       |
    |       | El sistema registra un nuevo paciente.

**Flujo Alternativo**:

- Paso 7: Si no se ingresa alguno o ninguno de los datos y/o se ingresaron incorrectamente, se informa al usuario y se retorna al paso 3.
- Paso 9: Si el paciente ya está registrado en el sistema, el sistema muestra el mensaje de error “Este paciente ya está registrado”y redirige al paso 3.

## Vista de Registro de Psicólogo
![psicologo](/img/poo2_6.jpg)

**Caso de uso**: Registrar Psicólogo

**Descripción**: El usuario desea registrar un nuevo psicólogo al sistema

**Precondición**:

**Postcondición**: El psicólogo debe quedar registrado.

**Flujo Tipico de Eventos**

Actor |                                                                                                                             Sistema                                                                                                                             |
:----------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
   Este caso de Uso comienza cuando el usuario hace clic sobre el apartado “Psicólogos”   |
   ----   |         El sistema muestra un formulario en la sección “Registrar Nuevo Psicólogo” con los siguientes campos:<br/>- Tipo<br/>- Número<br/> - Nombre<br/> - Apellido<br/> -Fecha de Nac.<br/> - Sexo<br/> Especialidad<br/> - Dirección<br/> - Teléfono          |
     El usuario selecciona el tipo de documento del psicólogo (Tipo)       |                                                                                                                                                                                                                                                                 |
      El usuario ingresa el identificador del psicólogo (Número)      |                                                                                                                                                                                                                                                                 |
|        |                                                                                               El sistema verifica que el ID (DNI) del psicólogo cargado no exista.                                                                                               
|   El usuario completa los campos con los datos del psicólogo.    |
|           |                                                                                             El sistema verifica si todos los datos fueron ingresados correctamente.                                                                                             
     El usuario hace clic sobre el botón “Agregar Psicólogo”   |                                                                                                                                                                                                                                                                 |
|       |                                                                                                             El sistema registra un nuevo psicólogo.                                                                                                              

**Flujo Alternativo**:

- Paso 7: Si no se ingresa alguno o ninguno de los datos y/o se ingresaron incorrectamente, se informa al usuario y se retorna al paso 3.
- Paso 9: Si el psicólogo ya está registrado en el sistema, el sistema muestra el mensaje de error “Este psicólogo ya está registrado”y redirige al paso 3.


## Vista Registrar Nueva Sesión
![sesion](/img/poo2_4.jpg)

**Caso de uso**: Registrar Sesión

**Descripción**: El usuario desea registrar una nueva sesión en el sistema.

**Precondición**: El Paciente que asiste a la sesión debe estar registrado. El Psicólogo que asiste a la sesión debe estar registrado. 
La fecha y hora seleccionada para la sesión deben estar disponibles.

**Postcondición**: La sesión debe estar registrada.

**Flujo Tipico de Eventos**

Actor |                                                                                                                               Sistema                                                                                                                                |
:----------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
   Este caso de Uso comienza cuando el usuario hace clic sobre el apartado “Sesiones”   |
   ----   | El sistema muestra un formulario en la sección “Registrar Nuevo Psicólogo” con los siguientes campos:<br/>- Paciente<br/>- Psicólogo<br/> - Fecha de la Sesión<br/> - Hora de Sesión<br/> |
     El usuario ingresa al paciente que asistirá a la sesión.     |                                                                                                                                                                                                                                                                      |
|
|        |                                                                                                 El sistema verifica que el ID (DNI) del paciente cargado exista.                                                                                                
|   El usuario ingresa al psicólogo que asistirá a la sesión.    |
|           |                                                                                               El sistema verifica que el ID (DNI) del psicólogo cargado exista.                                                                                             
     El usuario ingresa la fecha en la que se realizará la sesión.   |                                                                                                                                                                                                                                                                      |
|       |                                                                                                               El sistema verifica que la fecha seleccionada se encuentre disponible y no sea anterior a la actual.
     El usuario ingresa la hora en la que se realizará la sesión.   El usuario ingresa la hora en la que se realizará la sesión.|    | 
      |   | El sistema verifica que la hora ingresada se encuentre disponible y no sea anterior a la actual.

**Flujo Alternativo**:
- Paso 4: Si el paciente no existe en el sistema, se muestra un mensaje “paciente inexistente” y se retorna al paso 3.
- Paso 6: Si el psicólogo no existe en el sistema, se muestra un mensaje “psicólogo inexistente” y se retorna al paso 5.
- Paso 8: Si la fecha seleccionada no está disponible o corresponde a una fecha anterior a la actual, se muestra un mensaje “Fecha invalida” y se retorna al paso 7.
- Paso 10: Si la hora seleccionada no está disponible o corresponde a una hora anterior a la actual, se muestra un mensaje “Hora invalida” y se retorna al paso 9.



# Backlog de iteraciones 
### Sprint 1
1. HU-001: Registrar paciente.
2. HU-002: Modificar paciente.
3. HU-003: Eliminar paciente.
4. HU-004: Listar pacientes.
5. HU-005: Registrar Psicólogo.
6. HU-006: Modificar Psicólogo.
7. HU-007: Eliminar Psicólogo.
8. HU-008: Listar Psicólogos.
8. HU-013: Registrar Sesión.
9. HU-014: Modificar Sesión.
10. HU-015: Cancelar Sesión.
11. HU-016: Listar Sesiones.


# Tareas

### HU-001, HU-002, HU-003, HU-004.

- Crear la interfaz PacienteRepositorio.
- Crear la interfaz PacienteServicio con los metodos a ser implementados en la clase “PacienteServicioImpl”.
- Crear una carpeta impl (una sola vez por carpeta de “servicies”)
- Crear una clase PacienteServicioImpl (dentro de la carpeta impl) donde se inyectará el repositorio anteriormente creado.
- Crear el controlador para la clase en particular PacienteController en el cual se inyectará la clase PacienteServicioImpl.

### HU-005, HU-006, HU-007, HU-008.

- Crear la interfaz PsicologoRepositorio.
- Crear la interfaz PsicologoServicio con los métodos a ser implementados en la clase “PsicologoServicioImpl”.
- Crear una clase PsicologoServicioImpl (dentro de la carpeta impl) donde se inyectará el repositorio anteriormente creado.
- Crear el controlador para la clase en particular PsicologoController en el cual se inyectará la clase PsicologoServicioImpl.

### HU-013, HU-014, HU-015, HU-016

- Crear la interfaz SesionRepositorio.
- Crear la interfaz SesionServicio con los métodos a ser implementados en la clase “SesionServicioImpl”.
- Crear una clase SesionServicioImpl (dentro de la carpeta impl) donde se inyectará el repositorio anteriormente creado.
- Crear el controlador para la clase en particular SesionController en el cual se inyectará la clase SesionServicioImpl.

# Retrospectiva
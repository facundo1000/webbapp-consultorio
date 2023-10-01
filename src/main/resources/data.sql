-- Insertar datos de psicologo
INSERT INTO psicologo (dni,apellido,nombre,direccion,fecha_de_nacimiento,sexo, telefono, especialidad, eliminado)
VALUES (40356896,'perez','ricardo','','1998-05-16','MASCULINO','01136987359','analista', false);

-- Insertar datos de paciente

INSERT INTO paciente (dni,apellido,nombre,direccion,fecha_de_nacimiento,sexo, telefono, estado_civil, eliminado, ocupacion)
VALUES (39789654,'tabertini','jorge','martinez de hoz 789','1979-06-24','MASCULINO','3764253984','SOLTERO',true, 'desarrollador');

INSERT INTO paciente (dni,apellido,nombre,direccion,fecha_de_nacimiento,sexo, telefono, estado_civil, eliminado, ocupacion)
VALUES (34789654,'garcia','lucrecia','salta 1879','1987-05-27','FEMENINO','3764123492','CASADO',false, 'taxista');

-- Insertar datos de secretario
INSERT INTO secretario (dni,apellido,nombre,direccion,fecha_de_nacimiento,sexo, telefono, eliminado)
VALUES (40357159,'baez','paola','alvear 1234','1994-06-28','FEMENINO','3764796431',false);


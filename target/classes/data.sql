-- Insertar datos de psicologo
INSERT INTO psicologo (dni,apellido,nombre,direccion,fecha_de_nacimiento,sexo, telefono, especialidad, eliminado,tipo_doc) VALUES (40356896,'perez','ricardo','pellegrini 987','1998-05-16','MASCULINO','01136987359','PSICOANALISIS', false,'DNI');
INSERT INTO psicologo (dni,apellido,nombre,direccion,fecha_de_nacimiento,sexo, telefono, especialidad, eliminado,tipo_doc) VALUES (12345678,'López','María','Calle 123','1990-03-25','FEMENINO','01123456789','PSICOANALISIS', false,'DNI');
INSERT INTO psicologo (dni,apellido,nombre,direccion,fecha_de_nacimiento,sexo, telefono, especialidad, eliminado,tipo_doc) VALUES (87654321,'González','Javier','Avenida 456','1985-11-10','MASCULINO','01187654321','PSICOTERAPIA', false,'DNI');


-- Insertar datos de paciente

INSERT INTO paciente (dni,apellido,nombre,direccion,fecha_de_nacimiento,sexo, telefono, estado_civil, eliminado, ocupacion,tipo_doc, psicologo_dni) VALUES (39789654,'tabertini','jorge','martinez de hoz 789','1979-06-24','MASCULINO','3764253984','SOLTERO',false, 'desarrollador','LE',12345678);
INSERT INTO paciente (dni,apellido,nombre,direccion,fecha_de_nacimiento,sexo, telefono, estado_civil, eliminado, ocupacion,tipo_doc, psicologo_dni) VALUES (34789654,'garcia','lucrecia','salta 1879','1987-05-27','FEMENINO','3764123492','CASADO',false, 'taxista','DNI', 40356896);
INSERT INTO paciente (dni, apellido, nombre, direccion, fecha_de_nacimiento, sexo, telefono, estado_civil, eliminado, ocupacion, tipo_doc, psicologo_dni) VALUES (12345678,'Lopez','Juan','Calle 123','1990-02-15','MASCULINO','1234567890','SOLTERO',false,'Ingeniero','DNI', 87654321);
INSERT INTO paciente (dni, apellido, nombre, direccion, fecha_de_nacimiento, sexo, telefono, estado_civil, eliminado, ocupacion, tipo_doc, psicologo_dni) VALUES (23456789,'Martinez','Ana','Avenida 567','1985-09-10','FEMENINO','9876543210','CASADO',false,'Doctora','DNI', 40356896);
INSERT INTO paciente (dni, apellido, nombre, direccion, fecha_de_nacimiento, sexo, telefono, estado_civil, eliminado, ocupacion, tipo_doc, psicologo_dni) VALUES (34567890,'Perez','Carlos','Calle 890','1978-11-20','MASCULINO','5432167890','DIVORCIADO',false,'Profesor','DNI', 87654321);


-- Insertar datos de secretario
INSERT INTO secretario (dni,apellido,nombre,direccion,fecha_de_nacimiento,sexo, telefono, eliminado,tipo_doc) VALUES (40357159,'baez','paola','alvear 1234','1994-06-28','FEMENINO','3764796431',false,'PASAPORTE');
INSERT INTO secretario (dni, apellido, nombre, direccion, fecha_de_nacimiento, sexo, telefono, eliminado, tipo_doc) VALUES (30159756, 'perez', 'juan', 'calle 5678', '1990-03-15', 'MASCULINO', '1234567890', false, 'DNI');

-- Insertar datos de sesion
INSERT INTO sesion (nro_sesion,fecha,hora,psicologo_dni,paciente_dni, eliminado,estado) VALUES (12,'2023-08-10','16:30',40356896,34789654, false,'REALIZADA');
INSERT INTO sesion (nro_sesion,fecha,hora,psicologo_dni,paciente_dni, eliminado,estado) VALUES (11,'2022-07-11','14:00',12345678,39789654, false,'PENDIENTE');
INSERT INTO sesion (nro_sesion,fecha,hora,psicologo_dni,paciente_dni, eliminado,estado) VALUES (13,'2023-10-22','17:00',87654321,12345678, true,'CANCELADA');


-- Insertar historia_clinica
INSERT INTO historia_clinica (cant_sesiones) VALUES (3);

-- Insertar informe de sesion
INSERT INTO informe_sesion (fecha_informe,hora_informe,analisis,notas,conclusion,tareas,eliminado,sesion_id,historia_id) VALUES ('2023-03-01', '08:30','descripcion de prueba','informacion de las notas','informacion de la conclusion','esto es una tarea',false,12,1);

-- Insertar derivacion de psicologo
INSERT INTO derivacion (nombre_dest,apellido_dest,tipo_doc_dest,dni_dest,clinica_dest,tel_clinica_dest,direc_clinica_dest,descripcion,psicologo_emisor_dni, paciente_dni, eliminado) VALUES ('armando','martinez','DNI','46639845','clinica mayo','+5578965412', 'fuenzalida 145','el paciente debe ser tranferido a la clinica mayo',12345678,34789654,false);

-- relacion psicologo-derivacion
INSERT INTO tbl_psicologo_derivaciones (psicologo_id,derivacion_id) VALUES (12345678,1);

-- relacion informeSesion-historiaClinica
INSERT INTO tbl_informe_historia (historia_id,informe_id) VALUES (1,1);

-- relacion paciente_psicologo
INSERT INTO tbl_paciente_psicologo (psicologo_id, paciente_id) VALUES (40356896,34789654);

-- relacion paciente_sesion
INSERT INTO tbl_paciente_sesion (paciente_id, sesion_id) VALUES (34789654,12);

-- relacion psicologo-sesion
INSERT INTO tbl_psicologo_sesion (psicologo_id, sesion_id) VALUES (40356896,12);
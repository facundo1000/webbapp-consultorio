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

-- Insertar datos de sesion
INSERT INTO sesion (nro_sesion,fecha,hora,psicologo_dni,paciente_dni, eliminado) VALUES (12,'2023-08-10','16:30',40356896,34789654, false);

-- relacion paciente_psicologo

INSERT INTO tbl_paciente_psicologo (psicologo_id, paciente_id) VALUES (40356896,34789654);

INSERT INTO tbl_paciente_sesion (paciente_id, sesion_id) VALUES (34789654,12);

INSERT INTO tbl_psicologo_sesion (psicologo_id, sesion_id) VALUES (40356896,12);
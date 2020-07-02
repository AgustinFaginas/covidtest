INSERT INTO provincia (id)
VALUES (1);
INSERT INTO provincia (id)
VALUES (2);

INSERT INTO partido (id,provincia_id)
VALUES (1, 1);
INSERT INTO partido (id,provincia_id)
VALUES (2, 1);
INSERT INTO partido (id,provincia_id)
VALUES (3, 2);

INSERT INTO localidad (id,partido_id)
VALUES (1, 1);
INSERT INTO localidad (id,partido_id)
VALUES (2, 1);

INSERT INTO domicilio(id,calle,numero,localidad_id)
VALUES (1, "Las heras", 123, 1);
INSERT INTO domicilio(id,calle,numero,localidad_id)
VALUES (2, "Los arcos", 323, 1);
INSERT INTO domicilio(id,calle,numero,localidad_id)
VALUES (3, "Peribebuy", 3533, 1);
INSERT INTO domicilio(id,calle,numero,localidad_id)
VALUES (4, "Ing huergo", 1432, 2);

INSERT INTO usuario(DTYPE, id, nombre, apellido, email, password, numeroDocumento, tipoDocumento, domicilio_id, infectado, posibleInfectado)
VALUES ("Paciente", 1, "nombre1_pac", "apellido1", "email1_pac@email.com", "password1_pac", "1", "DNI", 1, true, true),
	  ("Paciente", 2, "nombre2_pac", "apellido2", "email2_pac@email.com", "password2_pac", "2", "DNI", 2, false, true),
      ("Paciente", 3, "nombre3_pac", "apellido3", "email3_pac@email.com", "password3_pac", "3", "DNI", 3, true, true),
	  ("Paciente", 4, "nombre4_pac", "apellido4", "email4_pac@email.com", "password4_pac", "4", "DNI", 4, false, false),
      ("Paciente", 9, "nombre9_pac", "apellido9", "email9_pac@email.com", "password9_pac", "5", "DNI", 3, true, true),
      ("Paciente", 10, "nombre10_pac", "apellido10", "email10_pac@email.com", "password10_pac", "6", "DNI", 3, true, true),
      ("Paciente", 11, "nombre11_pac", "apellido11", "email11_pac@email.com", "password11_pac", "7", "DNI", 3, true, true),
      ("Paciente", 12, "nombre12_pac", "apellido12", "email12_pac@email.com", "password12_pac", "8", "DNI", 3, true, true),
      ("Paciente", 13, "nombre1_pac", "apellido1", "email1_pac@email.com", "password1_pac", "9", "DNI", 1, true, true),
	  ("Paciente", 14, "nombre2_pac", "apellido2", "email2_pac@email.com", "password2_pac", "10", "DNI", 2, false, true),
      ("Paciente", 15, "nombre3_pac", "apellido3", "email3_pac@email.com", "password3_pac", "11", "DNI", 3, true, true),
	  ("Paciente", 16, "nombre4_pac", "apellido4", "email4_pac@email.com", "password4_pac", "12", "DNI", 4, false, false),
      ("Paciente", 17, "nombre9_pac", "apellido9", "email9_pac@email.com", "password9_pac", "13", "DNI", 3, true, true),
      ("Paciente", 18, "nombre10_pac", "apellido10", "email10_pac@email.com", "password10_pac", "14", "DNI", 3, true, true),
      ("Paciente", 19, "nombre11_pac", "apellido11", "email11_pac@email.com", "password11_pac", "15", "DNI", 3, true, true),
      ("Paciente", 20, "nombre12_pac", "apellido12", "email12_pac@email.com", "password12_pac", "16", "DNI", 3, true, true);
	
      
      INSERT INTO usuario(DTYPE, id, nombre, email, password, rol, numeroDocumento, tipoDocumento, cantidadCamas, domicilio_id)
VALUES ("Institucion", 5, "nombre1_inst", "email1_inst@email.com", "password1_inst","ADMIN", "1", "CUIT", 20, 1),
      ("Institucion", 6, "nombre2_inst", "email2_inst@email.com", "password2_inst","INSTITUCION","2", "CUIT", 10, 2),
      ("Institucion", 7, "nombre3_inst", "email3_inst@email.com", "password3_inst","INSTITUCION","3", "CUIT", 15, 3),
      ("Institucion", 8, "nombre4_inst", "email4_inst@email.com", "password4_inst","INSTITUCION","4", "CUIT", 7, 4);
    
INSERT INTO cama(id, descripcion, tipoCama, institucion_id)
VALUES (1, "101", "FIJA", 6),
	   (2, "102", "FIJA", 6),
       (3, "103", "FIJA", 6),
       (4, "104", "FIJA", 6),
	   (5, "105", "FIJA", 6),
       (6, "106", "FIJA", 6),
       (7, "107", "FIJA", 6),
	   (8, "108", "FIJA", 6),
       (9, "109", "FIJA", 7),
       (10, "110", "FIJA", 7),
	   (11, "111", "FIJA", 8),
       (12, "112", "FIJA", 8),
       (13, "113", "FIJA", 6),
	   (14, "114", "FIJA", 6),
       (15, "115", "FIJA", 6),
       (16, "116", "FIJA", 6),
	   (17, "117", "FIJA", 6),
       (18, "118", "FIJA", 6),
       (19, "119", "FIJA", 6),
	   (20, "120", "FIJA", 6),
       (21, "121", "FIJA", 7),
       (22, "122", "FIJA", 7),
	   (23, "123", "FIJA", 8),
       (24, "124", "FIJA", 8);
    
INSERT INTO asignacion(id, horaIngreso, horaEgreso, motivoEgreso, cama_id, paciente_id)
VALUES (1, '2020-01-01 01:00:00.000000', null, null, 1, 1),
	   (2, '2020-02-01 01:00:00.000000', null, null, 3, 2),
       (3, '2020-03-01 01:00:00.000000', null, null, 6, 3),
	   (4, '2020-04-01 01:00:00.000000', null, null, 5, 4);
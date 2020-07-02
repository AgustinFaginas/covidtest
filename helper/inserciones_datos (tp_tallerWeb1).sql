INSERT INTO provincia (id, nombreProvincia)
VALUES (1, "BUENOS_AIRES"),
	   (2, "CORDOBA"),
       (3, "SANTA_FE");

INSERT INTO partido (id, nombrePartido ,provincia_id)
VALUES (1, "MORON", 1),
	   (2, "EZEIZA", 1),
       (3, "AVELLANEDA", 1),
       (4, "TRES_DE_FEBRERO", 1),
       (5, "SAN_JUSTO", 1),
       (6, "MONSERRAT", 1);

INSERT INTO localidad (id, nombreLocalidad, partido_id)
VALUES (1,"CASTELAR", 1),
	   (2, "SARANDI", 3),
	   (3, "WILDE", 3),
       (4, "CIUDADELA", 4),
       (5, "MORON", 1),
       (6, "SAN_JUSTO", 5),
       (7, "MONSERRAT", 6);

INSERT INTO domicilio(id, calle, numero, localidad_id)
VALUES (1, "Las Heras", 1200, 1),
	   (2, "Los Arcos", 3300, 1),
	   (3, "Peribebuy", 450, 6),
	   (4, "Ingeniero Huergo", 1550, 6),
       (5, "Hipólito Yrigoyen", 1650, 4),
       (6, "Pilar", 950, 6),
       (7, "Av. Rivadavia", 17961, 5),
       (8, "Solís", 463, 5);

/* ----- ADMIN ----- */
INSERT INTO usuario(rol, DTYPE, id, nombre, email, password, numeroDocumento, tipoDocumento, cantidadCamas, domicilio_id)
VALUES ("ADMIN", "Institucion", 1, "Operadora Central 1", "admin@email.com", "1234", "20100041007", "CUIT", null, 1);

/* ----- HOSPITAL ----- */
INSERT INTO usuario(rol, DTYPE, id, nombre, email, password, numeroDocumento, tipoDocumento, cantidadCamas, domicilio_id)
VALUES ("INSTITUCION", "Institucion", 2, "Fundación Favaloro", "favaloro@email.com", "1234","20200020007", "CUIT", 40, 2),
       ("INSTITUCION", "Institucion", 3, "Hospital Italiano De Morón", "hospital_italiano_moron@email.com", "1234","20300030007", "CUIT", 65, 7),
       ("INSTITUCION", "Institucion", 4, "Hospital Donación Francisco Santojanni", "santojanni@email.com", "1234","20400040007", "CUIT", 57, 6),
       ("INSTITUCION", "Institucion", 5, "Hospital Profesor Doctor Ramón Carrillo", "carillo@email.com", "1234", "20500050007", "CUIT", 57, 5);
       
/* ----- PACIENTE TESTEADOS POSIVOS----- */       
INSERT INTO usuario(rol, DTYPE, id, nombre, apellido, email, password, numeroDocumento, tipoDocumento, domicilio_id, posibleInfectado, infectado)
VALUES("PACIENTE", "Paciente", 6, "Alejandra", "Rodriguez", "alejandro@email.com", "1234", "1", "DNI", 2, true, null),
      ("PACIENTE", "Paciente", 7, "Alejandra", "Rodriguez", "alejandra@email.com", "1234", "2", "DNI", 3, true, null),
	  ("PACIENTE", "Paciente", 8, "Alan", "Rodriguez", "alan@email.com", "1234", "3", "DNI", 4, true, null),
      ("PACIENTE", "Paciente", 9, "Ana", "Rodriguez", "ana@email.com", "1234", "3", "DNI", 3, true, null),
      ("PACIENTE", "Paciente", 10, "Carlos", "Gómez", "carlos@email.com", "1234", "32100100", "DNI", 3, true, null),
      ("PACIENTE", "Paciente", 11, "Carla", "Gómez", "carla@email.com", "1234", "32110100", "DNI", 3, true, null);

/* ----- PACIENTE INFECTADOS----- */ 
INSERT INTO usuario(rol, DTYPE, id, nombre, apellido, email, password, numeroDocumento, tipoDocumento, domicilio_id, posibleInfectado, infectado)
VALUES("PACIENTE", "Paciente", 12, "Cristian", "Gómez", "cristian@email.com", "1234", "32120100", "DNI", 3, null, true),
      ("PACIENTE", "Paciente", 13, "Celeste", "Gómez", "celeste@email.com", "1234", "32130100", "DNI", 1, null, true),
	  ("PACIENTE", "Paciente", 14, "Dario", "García", "dario@email.com", "1234", "32140100", "DNI", 2, null, true),
      ("PACIENTE", "Paciente", 15, "Danila", "García", "danila@email.com", "1234", "32150100", "DNI", 3, null, true),
	  ("PACIENTE", "Paciente", 16, "Daniel", "García", "daniel@email.com", "1234", "32106100", "DNI", 4, null, false),
      ("PACIENTE", "Paciente", 17, "Daniela", "García", "daniela@email.com", "1234", "32160100", "DNI", 3, null, true),
      ("PACIENTE", "Paciente", 18, "Fabricio", "García", "fabricio@email.com", "1234", "32170100", "DNI", 1, null, true),
      ("PACIENTE", "Paciente", 19, "Fabián", "García", "fabian@email.com", "1234", "32108100", "PASAPORTE", 1, null, true),
      ("PACIENTE", "Paciente", 20, "Fabiana", "Garcia", "email12_pac@email.com", "1234", "16", "PASAPORTE", 3, true, true);
    
INSERT INTO cama(id, descripcion, tipoCama, institucion_id)
VALUES (1, "101", "FIJA", 2),
	   (2, "102", "FIJA", 2),
       (3, "103", "FIJA", 2),
       (4, "104", "FIJA", 2),
	   (5, "105", "FIJA", 2),
       (6, "106", "FIJA", 2),
       (7, "107", "FIJA", 2),
	   (8, "108", "FIJA", 2),
       (9, "109", "FIJA", 2),
       (10, "110", "FIJA", 2),
	   (11, "111", "FIJA", 2),
       (12, "112", "FIJA", 2),
       (13, "113", "FIJA", 2),
	   (14, "114", "FIJA", 2),
       (15, "115", "FIJA", 2),
       (16, "116", "FIJA", 3),
	   (17, "117", "FIJA", 3),
       (18, "118", "FIJA", 3),
       (19, "119", "FIJA", 3),
	   (20, "120", "FIJA", 3),
       (21, "121", "FIJA", 3),
       (22, "122", "FIJA", 4),
	   (23, "123", "FIJA", 4),
       (24, "124", "FIJA", 4),
       (25, "101", "FIJA", 4),
	   (26, "102", "FIJA", 4),
       (27, "103", "FIJA", 4),
       (28, "104", "FIJA", 4),
	   (29, "105", "FIJA", 4),
       (30, "106", "FIJA", 4),
       (31, "107", "FIJA", 4),
	   (32, "108", "FIJA", 5),
       (33, "109", "FIJA", 5),
       (34, "110", "FIJA", 5),
	   (35, "111", "FIJA", 5),
       (36, "112", "FIJA", 5),
       (37, "113", "FIJA", 5),
	   (38, "114", "FIJA", 5),
       (39, "115", "FIJA", 5),
       (40, "116", "FIJA", 5),
	   (41, "117", "FIJA", 5),
       (42, "118", "FIJA", 5),
       (43, "119", "FIJA", 5),
	   (44, "120", "FIJA", 5),
       (45, "121", "FIJA", 5),
       (46, "122", "FIJA", 5),
	   (47, "123", "FIJA", 5),
       (48, "124", "FIJA", 5);
    
/* ----- INTERNACION ----- */     
INSERT INTO asignacion(id, horaIngreso, horaEgreso, motivoEgreso, cama_id, paciente_id)
VALUES (1, '2020-01-01 01:00:00.000000', null, null, 1, 9),
	   (2, '2020-02-01 01:00:00.000000', null, null, 3, 10),
       (3, '2020-03-01 01:00:00.000000', null, null, 6, 11),
	   (4, '2020-04-01 01:00:00.000000', null, null, 5, 12);

/* ----- EGRESO ----- */        
INSERT INTO asignacion(id, horaIngreso, horaEgreso, motivoEgreso, cama_id, paciente_id)
VALUES (5, '2020-01-01 01:00:00.000000', '2020-02-01 01:00:00.000000', "CURADO", 10, 15),
	   (6, '2020-02-01 01:00:00.000000', '2020-02-01 01:00:00.000000', "CURADO", 11, 16),
       (7, '2020-03-01 01:00:00.000000', '2020-02-01 01:00:00.000000', "FALLECIDO", 12, 17),
	   (8, '2020-04-01 01:00:00.000000', '2020-02-01 01:00:00.000000', "TRASLADADO", 13, 18);
       
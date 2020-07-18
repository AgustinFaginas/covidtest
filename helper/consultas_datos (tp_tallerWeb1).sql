SELECT * 
FROM Usuario;

SELECT * 
FROM Notificacion;

SELECT * 
FROM Usuario
WHERE DTYPE = "Paciente";

SELECT * 
FROM Usuario
WHERE DTYPE = "Institucion";

SELECT * 
FROM Asignacion;

SELECT * 
FROM Notificacion;

SELECT *
FROM Cama;

SELECT *
FROM Domicilio;

SELECT *
FROM Localidad;

SELECT *
FROM Partido;

SELECT *
FROM Provincia;

/* ----- Internaciones ----- */ 
SELECT *
FROM Asignacion asig
WHERE asig.motivoEgreso IS NULL
AND asig.horaEgreso IS NULL;

/* ----- Egresos ----- */ 
SELECT *
FROM Asignacion asig
WHERE asig.motivoEgreso IS NOT NULL
AND asig.horaEgreso IS NOT NULL;

/*-------Todas las asignaciones realizadas-----------*/
SELECT asig.id as nro_asig,  cama.id as cama_id, us.nombre as nombre_institucion 
FROM Asignacion asig
JOIN Cama ON cama.id = asig.cama_id
JOIN Usuario us ON us.id = cama.institucion_id
JOIN Usuario us2 ON us2.id = asig.paciente_id;

/*-------Todas las asignaciones realizadas con las camas-----------*/
SELECT *
FROM Cama c 
	JOIN Asignacion a 
    ON c.id = a.cama_id;
    
/*-------Todas las asignaciones vigentes con las camas ocupadas-----------*/
SELECT *
FROM Cama c 
	JOIN Asignacion a 
    ON c.id = a.cama_id
WHERE a.horaEgreso IS NULL;

/*------- Mostrar todas las camas tal para las cuales no existe una asignacion vigente (EXISTS no es reconido en HQL query)------------*/
SELECT *
FROM cama c
WHERE NOT EXISTS (SELECT 1
 			   FROM asignacion a
			   WHERE a.cama_id = c.id
			   AND a.horaEgreso IS NULL);     
               
/*------ Mostrar todas las camas tal para las cuales no existe una asignacion vigente ------*/
SELECT *
FROM cama c
WHERE c.id NOT IN (SELECT a.cama_id
 			   FROM asignacion a
			   WHERE a.cama_id = c.id
			   AND a.horaEgreso IS NULL);                  
             
/*------ Mostrar la cantidad de camas por institucion tal para las cuales no existe una asignacion vigente ------*/
SELECT i.*,  count(*) as camas_disponibles
FROM cama c JOIN usuario i ON c.institucion_id = i.id
WHERE c.id NOT IN (SELECT a.cama_id
 			   FROM asignacion a
			   WHERE a.cama_id = c.id
			   AND a.horaEgreso IS NULL)
GROUP BY c.institucion_id;                  


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
FROM Usuario us 
	JOIN Asignacion asig 
    ON us.id = asig.paciente_id;

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

/* ----- INTERNACION ----- */ 
SELECT *
FROM Asignacion asig
WHERE asig.motivoEgreso IS NULL
AND asig.horaEgreso IS NULL;

/* ----- EGRESO ----- */ 
SELECT *
FROM Asignacion asig
WHERE asig.motivoEgreso IS NOT NULL
AND asig.horaEgreso IS NOT NULL;

SELECT asig.id as nro_asig, us2.nombre as nombre_paciente, cama.id as cama_id, us.nombre as nombre_institucion 
FROM Asignacion asig
JOIN Cama ON cama.id = asig.cama_id
JOIN Usuario us ON us.id = cama.institucion_id
JOIN Usuario us2 ON us2.id = asig.paciente_id;

SELECT *
FROM Cama c 
	JOIN Asignacion a 
    ON c.id = a.cama_id;
                  
SELECT a.cama_id
FROM Asignacion a 
WHERE NOT EXISTS (SELECT 1
				   
                  AND a.horaEgreso IS NULL);
                  
SELECT c.id
FROM cama c
WHERE NOT EXISTS (SELECT 1
				  FROM asignacion a
				  WHERE NOT EXISTS (SELECT 1
								    WHERE c.id = a.cama_id
                                    AND a.horaEgreso IS NULL));                  

SELECT c.id
FROM cama c
WHERE c.institucion_id = 2
AND NOT EXISTS (SELECT 1
 			   FROM asignacion a
			   WHERE a.cama_id = c.id
			   AND a.horaEgreso IS NULL);     

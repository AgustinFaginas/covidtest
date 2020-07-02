USE tp_db; /*La eliminación siguiente se hace únicamente sobre la BD mencionada*/

SET sql_safe_updates=0;
DELETE FROM asignacion;
DELETE FROM cama;
DELETE FROM usuario; 
DELETE FROM domicilio;
DELETE FROM localidad;
DELETE FROM partido;
DELETE FROM provincia;
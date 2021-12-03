-- Listar los datos de los autores
SELECT * FROM AUTOR;
-- Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM ESTUDIANTE;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT Nombre, Apellido FROM ESTUDIANTE	WHERE Carrera = "informatica";
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT Nombre FROM AUTOR WHERE nacionalidad = "Francesa" OR nacionalidad = "Italiana";
-- ¿Qué libros no son del área de internet?
SELECT Titulo FROM LIBRO WHERE area != "internet";
-- Listar los libros de la editorial Salamandra
SELECT Titulo FROM LIBRO WHERE Editorial = "Salamandra";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio
SELECT * FROM ESTUDIANTE WHERE Edad > (SELECT AVG(Edad) FROM ESTUDIANTE);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G
SELECT Nombre FROM ESTUDIANTE WHERE Apellido LIKE "G%";
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres)
SELECT Nombre FROM AUTOR WHERE idAutor IN
	(SELECT  LIBROAUTOR.AUTOR_idAutor FROM LIBRO INNER JOIN LIBROAUTOR ON LIBRO.Titulo = "El Universo");



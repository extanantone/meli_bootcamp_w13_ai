use biblioteca; 

-- Listar los datos de los autores.
select * from AUTOR;

-- Listar nombre y edad de los estudiantes.
select es.nombre, TIMESTAMPDIFF(YEAR,es.FechaNacimiento,CURDATE()) as Edad FROM ESTUDIANTE as es;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from ESTUDIANTE as es where es.Carrera= 'Ciencias de la computación';

-- ¿Qué autores son de nacionalidad argentina o colombiana?
select * from AUTOR as au where au.Nacionalidad= 'Argentino' OR au.Nacionalidad= 'Colombiana';

-- ¿Qué libros no son del área de internet?
select * from LIBRO as li where li.Area != 'internet';

-- Listar los libros de la editorial Salamandra.
select * from LIBRO as li where li.Editorial= 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select es.Nombre as Nombre, es.Apellido as Apellido, TIMESTAMPDIFF(YEAR,es.FechaNacimiento,CURDATE()) as edad, prom as prom from estudiante as es, (
	select avg(TIMESTAMPDIFF(YEAR,es.FechaNacimiento,CURDATE())) as prom from ESTUDIANTE as es
) promedio having edad > prom;

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select es.Nombre from ESTUDIANTE as es where es.Apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select au.Nombre from AUTOR as au, LIBRO as li INNER JOIN LIBROAUTOR as la where li.Titulo='El Universo: Guía de viaje' AND la.idLIBRO= li.idLIBRO


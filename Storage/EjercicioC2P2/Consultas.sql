-- Listar los datos de los autores.
SELECT * FROM biblioteca.autor;

-- Listar nombre y edad de los estudiantes.
SELECT nombre, edad FROM biblioteca.alumno;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM biblioteca.alumno WHERE carrera = 'Informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM biblioteca.autor WHERE nacionalidad='Francesa' OR nacionalidad='Italiana';

-- ¿Qué libros no son del área de internet?
SELECT * FROM biblioteca.libro WHERE area <> 'Internet';

-- Listar los libros de la editorial Salamandra.
SELECT * FROM biblioteca.libro WHERE editorial <> 'Salamanca';

--Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM biblioteca.alumno WHERE edad> (SELECT avg(edad) FROM biblioteca.alumno);

--Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM biblioteca.alumno WHERE apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM biblioteca.autor a
INNER JOIN biblioteca.libro_autor la ON a.id_autor = la.id_autor 
INNER JOIN biblioteca.libro l ON la.id_libro = l.id_libro 
WHERE titulo = 'El Universo: Guía de viaje';

-- Listar autores que tengan la nacionalidad italiana o argentina.
SELECT * FROM biblioteca.autor WHERE nacionalidad='Argentina' OR nacionalidad='Italiana';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT titulo, editorial, area FROM biblioteca.libro l
INNER JOIN biblioteca.prestamo p ON l.id_libro=p.id_libro
INNER JOIN biblioteca.alumno a ON p.id_lector = a.id_lector
WHERE nombre = 'Filippo' AND apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT * FROM biblioteca.alumno WHERE edad = (SELECT min(edad) FROM biblioteca.alumno);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT a.nombre FROM biblioteca.alumno a
INNER JOIN biblioteca.prestamo p ON a.id_lector= p.id_lector
INNER JOIN biblioteca.libro l ON p.id_libro = l.id_libro
WHERE titulo LIKE '%Base de Datos%';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT TITULO FROM biblioteca.libro l
INNER JOIN biblioteca.libro_autor la ON l.id_libro = la.id_autor 
INNER JOIN biblioteca.autor a ON la.id_autor = a.id_autor 
WHERE nombre = 'J.K.' AND apellido = 'Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo FROM biblioteca.libro l 
INNER JOIN biblioteca.prestamo p ON l.id_libro = p.id_libro 
WHERE fecha_devolucion='2021-07-16';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM biblioteca.alumno WHERE edad > (SELECT avg(edad) FROM biblioteca.alumno);


use biblioteca;

insert into autor (idAutor, nombre, nacionalidad) values (1, "Jose Hernandez", "Argentino");
insert into autor (idAutor, nombre, nacionalidad) values (2, "J K Rowling", "Britanica");
insert into autor (idAutor, nombre, nacionalidad) values (3, "Jorge Luis Borges", "Argentino");
insert into autor (idAutor, nombre, nacionalidad) values (4, "Antoine de Saint-Exupéry ", "Frances");
insert into autor (idAutor, nombre, nacionalidad) values (5, "Gabriel García Marquez", "Colombiano");

insert into libro (idLibro, titulo, editorial, area) values (1, "El Principito", "editorial francesa", "fantasia");
insert into libro (idLibro, titulo, editorial, area) values (2, "Cien años de soledad", "editorial colombia", "drama");
insert into libro (idLibro, titulo, editorial, area) values (3, "Harry Potter", "editorial oxford", "fantasia");
insert into libro (idLibro, titulo, editorial, area) values (4, "Martin Fierro", "editorial argentina", "tradicion");
insert into libro (idLibro, titulo, editorial, area) values (5, "El amor en los tiempos del cólera", "editorial argentina", "drama");

insert into estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (1, "Alejandro", "Ferrero", "Cordoba 1234", "ingenieria", 23);
insert into estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (2, "Maria", "Sanchez", "San Martin 312", "abogacia", 25);
insert into estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (3, "Lucas", "Perez", "Illia 510", "medicina", 21);
insert into estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (4, "Martin", "Sanchez", "Corrientes 101", "arquitectura", 22);
insert into estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (5, "Lucia", "Di Santo", "Alvear 889", "arquitectura", 24);

insert into LibroAutor (idAutor, idLibro) values (1, 4);
insert into LibroAutor (idAutor, idLibro) values (2, 3);
insert into LibroAutor (idAutor, idLibro) values (4, 1);
insert into LibroAutor (idAutor, idLibro) values (5, 2);
insert into LibroAutor (idAutor, idLibro) values (5, 5);

insert into prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (1, 1, "2021-11-10 14:30:00", "2021-11-15 17:30:00", 1);
insert into prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (1, 2, "2021-04-10 11:30:00", null, 0);
insert into prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (2, 3, "2021-11-08 17:00:00", null, 0);
insert into prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (3, 3, "2021-10-01 15:00:00", "2021-11-02 12:00:00", 1);
insert into prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (4, 5, "2021-09-05 10:45:00", "2021-10-10 11:15:00", 1);

-- Consultas ---------------------------------------
-- Listar los datos de los autores.
select * from autor;
-- Listar nombre y edad de los estudiantes.
select nombre, apellido, edad from estudiante;
-- ¿Qué estudiantes pertenecen a la carrera informática?
select nombre, apellido from estudiante where carrera = "informática";
-- ¿Qué autores son de nacionalidad francesa o italiana?
select nombre, nacionalidad from autor where nacionalidad = "francesa" or "italiana";
-- ¿Qué libros no son del área de internet?
select titulo, editorial, area from libro where area != "internet";
-- Listar los libros de la editorial Salamandra.
select titulo, area from libro where editorial = "Salamandra";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select avg(edad) from estudiante);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre, apellido from estudiante where apellido like "G%";
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select ath.nombre 
from autor ath inner join LibroAutor la 
on ath.idAutor = la.idAutor 
where la.idLibro = (select idLibro from libro where titulo = "El Universo: Guía de viaje");
-- Listar autores que tengan la nacionalidad italiana o argentina.
select nombre, nacionalidad from autor where nacionalidad = "argentina" or "italiana";
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select titulo from libro 
where idLibro in (select idLibro from prestamo p inner join estudiante e 
						on p.idLector = e.idLector where e.nombre = "Filippo" and e.apellido = "Galli");
-- Listar el nombre del estudiante de menor edad.
select nombre, apellido from estudiante 
where edad = (select min(edad) from estudiante);
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select nombre, apellido from estudiante 
where idLector in (select idlector 
					from prestamo p inner join libro l 
					on l.idlibro = p.idlibro where l.area = "Base de Datos");
-- Listar los libros que pertenecen a la autora J.K. Rowling.
select titulo from libro 
where idLibro in (select idLibro 
					from LibroAutor la inner join autor a on la.idAutor = a.idAutor 
                    where a.nombre = "J. K. Rowling");
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select titulo 
from libro l inner join prestamo p
on l.idLibro = p.idLibro where DATE(fechaDevolucion) = "2021-07-16";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select avg(edad) from estudiante);





SELECT * FROM autor;
SELECT nombre, edad FROM estudiante;
SELECT * FROM autor
WHERE nacionalidad IN ("colombia", "argentina");
SELECT * FROM estudiante
WHERE carrera = "informatica";
Select * from libro
where area != 'area3';
Select * from libro     	
where editorial  ='editorial1';
select * from estudiante
where edad > (select avg(edad) from estudiante);
select * from estudiante
where apellido like 'A%5';
select autor.*, libro.* from autor
inner join libroautor on autor.idautor = libroautor.idautor
inner join libro on libroautor.idlibro = libro.idlibro
where libro.titulo = 'Libro4';
select autor.*, libro.* from autor
inner join libroautor on autor.idautor = libroautor.idautor
inner join libro on libroautor.idlibro = libro.idlibro
where autor.nacionalidad in ("colombia", "argent63ina");
10:08
Esto son para insertar:
10:08
USE biblioteca;
insert into autor (idautor, nombre, nacionalidad) values
(1,'Pedro', 'Colombia'),
(2,'Pedro2', 'ARGENTINA'),
(3,'Pedro3', 'Colombia'),
(4,'Pedro4', 'ARGENTINA'),
(5,'Pedro5', 'Colombia');
insert into libro (idlibro, titulo, editorial, area) values
(1,'Libro1', 'Editorial1','Area1'),
(2,'Libro2', 'Editorial2','Area3'),
(3,'Libro3', 'Editorial1','Area3'),
(4,'Libro4', 'Editorial2','Area1'),
(5,'Libro5', 'Editorial1','Area3');
insert into libroautor (idlibro, idautor) values
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);
insert into estudiante (idLector,nombre,apellido,direccion,carrera,edad) values
(6,'nombre6','apellido5','direccion5','informatica',28),
(7,'nombre7','apellido5','direccion5','informatica',28),
(8,'nombre8','apellido5','direccion5','informatica',28);
insert into prestamo (idlibro, idLector, fechaPrestamo, fechaDevolucion, devuelto) values
(1,2,'2021-11-10','2021-11-12',1),
(2,1,'2021-11-09','2021-11-15',1),
(3,8,'2021-11-08','2021-11-20',0);

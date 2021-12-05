use biblioteca;

-- EJ 01
select * from autor;

-- EJ 02
select nombre, edad
from estudiante;

-- EJ 03
select *
from estudiante
where carrera like '%informática%';

-- EJ 04
select *
from autor
where nacionalidad = 'francesa' or nacionalidad = 'italiana';

-- EJ 5
select * 
from Libro
where area not like '%internet%';

-- EJ 06
select *
from libro
where editorial = 'Salamandra';

-- EJ 07
select * 
from estudiante
where edad > (select avg(edad)
from estudiante);

-- EJ 08
select nombre 
from estudiante 
where apellido like 'G%';

-- EJ 09
select a.nombre
from autor a
join libroAutor la
on a.idAutor = la.idAutor
join libro l
on l.idLibro = la.idLibro
where l.titulo = 'El Universo: Guía de viaje';

-- EJ 10
select *
from estudiante
where carrera like '%informática%';

-- EJ 10
select *
from autor
where nacionalidad = 'italiana' or nacionalidad = 'argentina';

-- EJ 11
select l.titulo
from estudiante e
join prestamo p
on e.idLector = p.idLector
join libro l
on p.idLibro = l.idLibro
where concat(e.nombre, " ", e.apellido) = 'Filippo Galli';

-- EJ 12
select * 
from estudiante
order by edad
limit 1;

-- EJ 13
select e.nombre
from estudiante e
join prestamo p
on e.idLector = p.idLector
join libro l
on p.idLibro = l.idLibro
where l.titulo = 'Base de Datos';

-- EJ 14
select l.titulo
from autor a
join libroAutor la
on a.idAutor = la.idAutor
join libro l
on l.idLibro = la.idLibro
where a.nombre = 'Base de Datos';

-- EJ 15
select l.titulo
from prestamo p
join libro l
on p.idLibro = l.idLibro
where year(p.fechaDevolucion) = 2021 and 
month(p.fechaDevolucion) = 07 and
day(p.fechaDevolucion) = 16;

-- EJ 16
select * 
from estudiante
where edad > (select avg(edad)
from estudiante);
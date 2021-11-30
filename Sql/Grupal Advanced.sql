

select * from Autor;


SElECT Nombre, edad from Estudiante;


SELECT * FROM Estudiante where carrera='Informatica';


select * from Autor where nacionalidad in ('francesa','italiana');


select * from Libro where area <> 'Internet';

select * from Libro where editorial = 'Salamanca';


select * from Estudiante where edad > (select avg(edad) from Estudiante);

select nombre as nombre_estudiante from Estudiante where nombre like 'G%';

select au.* 
from Libro l, LibroAutor a, Autor au 
where l.titulo = 'El Universo: Guía de viaje' and au.idAutor = a.idAutor and l.idLibro=a.idLibro;

select *
from Autor
where nacionalidad in ('argentina','italiana');


select l.*
from Libro l inner join Prestamo p on l.idLibro=p.idLibro inner join Estudiante e on e.idLector=p.idLector
WHERE e.nombre='Filippo Galli';

select *
from estudiante
where edad = (select min(edad) from estudiante);

select e.*
from Libro l inner join Prestamo p on l.idLibro=p.idLibro inner join Estudiante e on e.idLector=p.idLector
WHERE l.titulo like '%Base de Datos%';


use movies_db;

select * from movies;
select * from genres;

-- Agregar una película a la tabla movies.
insert into movies 
values (33, null, null, "Shrek", 9.9, 10, "2012-09-10 00:00:00", 140, 10);
-- Agregar un género a la tabla genres.
insert into genres 
values (13, "2010-05-10 00:00:00", null, "Dibujos animados", 13, 1);
-- Asociar a la película del punto 1. con el género creado en el punto 2.
update movies set genre_id=13 where id=33;

select * from actors;
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors set favorite_movie_id=33 where id=47;

-- Crear una tabla temporal copia de la tabla movies.
drop table copy_movies;
create temporary table copy_movies
	select * from movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
delete from copy_movies where awards < 5;
SET SQL_SAFE_UPDATES = 1;
select * from copy_movies;

-- Obtener la lista de todos los géneros que tengan al menos una película.
select gen.name, count(*) as cantidad
from genres gen inner join movies mov
on gen.id = mov.genre_id
group by gen.name
having cantidad > 0; 

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select act.first_name, act.last_name, mov.title 
from actors act inner join movies mov
on mov.id = act.favorite_movie_id
where mov.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
create index indice_titulo on movies (title);

-- Chequee que el índice fue creado correctamente.
show index from movies;
EXPLAIN select * from movies where title LIKE "La Guerra%";

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
select count(*) from movies;
-- No existe una mejora notable ya que la base de datos movies no posee un gran numero de registros.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Crearia un indice en las tablas actors o episodes ya que son dos de las que mas registros poseen.

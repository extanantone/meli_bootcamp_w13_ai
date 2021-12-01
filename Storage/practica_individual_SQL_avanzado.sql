-- Consultas:
-- Mostrar el título y el nombre del género de todas las series.
select ser.title, gen.name 
from series ser inner join genres gen
on ser.genre_id = gen.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select epi.title, act.first_name, act.last_name
from episodes as epi inner join actor_episode as act_epi
on epi.id = act_epi.episode_id
inner join actors as act
on act.id = act_epi.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select ser.title as Titulo, count(*) as "Cant temporadas"  
from series ser inner join seasons sea
on ser.id = sea.serie_id
group by ser.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select gen.name as Nombre, count(*) as cant_peliculas
from genres gen inner join movies mov
on gen.id = mov.genre_id
group by gen.id
having cant_peliculas >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct act.first_name as nombre, act.last_name as apellido
from actors act inner join actor_movie act_mov
on act.id = act_mov.actor_id
where act_mov.movie_id in 
			(select id from movies 
				where title like "%La Guerra de las galaxias%");

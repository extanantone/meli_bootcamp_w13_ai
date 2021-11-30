-- PARTE 1
-- select * from tabla1 t1 join tabla2 t2 on t1.id = t2.id;
-- select * from tabla1 t1 left join tabla2 t2 on t1.id = t2.id;

-- PARTE 2
use movies_db;

-- EJ 01
select title, name 
from series s
join genres g
on s.genre_id = g.id;

-- EJ 02 
select title, first_name, last_name
from episodes e
join actor_episode ae
on e.id = ae.episode_id
join actors a 
on ae.actor_id = a.id;

-- EJ 03
select sr.title, count(*) as 'Cantidad de temporadas'
from series sr
join seasons sns
on sr.id = sns.serie_id
group by sr.title;

-- EJ 04
select g.name, count(*) as total_peliculas
from movies m
join genres g
on m.genre_id = g.id
group by g.name
having total_peliculas >= 3;

-- EJ 05
select DISTINCT a.first_name, a.last_name
from actors a
WHERE a.last_name IN (
select a2.last_name
from movies m
join actor_movie am
on m.id = am.movie_id
join actors a2
on a2.id = am.actor_id
where m.title like 'La Guerra de las galaxias%'
);
-- Mostrar todos los registros de la tabla de movies. 
select * from movies;

-- Mostrar el nombre, apellido y rating de todos los actores
select ac.first_name, ac.last_name, ac.rating from actors as ac;

-- Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
select se.title as titulo from series as se;

-- Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
select ac.first_name, ac.last_name from actors as ac where rating > 7.5;

-- Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
select mv.title, mv.rating, mv.awards from movies as mv where rating > 7.5 and awards > 2;

-- Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
select mv.title, mv.rating from movies as mv order by rating asc;

-- Mostrar los títulos de las primeras tres películas en la base de datos.
select mv.title from movies as mv limit 3;

-- Mostrar el top 5 de las películas con mayor rating.
select mv.title, mv.rating, mv.awards, mv.release_date, mv.length, mv.genre_id from movies as mv order by rating desc limit 5;

-- Listar los primeros 10 actores.
select ac.first_name, ac.last_name, ac.rating from actors as ac order by rating desc limit 10;

-- Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
select mv.title, mv.rating from movies as mv where title= "Toy Story";

-- Mostrar a todos los actores cuyos nombres empiezan con Sam.
select ac.first_name, ac.last_name from actors as ac where first_name= "Sam";

-- Mostrar el título de las películas que salieron entre el 2004 y 2008.
select mv.title, mv.release_date from movies as mv where mv.release_date between '2004-01-01' and '2008-01-01';

-- Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
select mv.title from movies as mv where mv.rating > 3 and mv.awards > 1 and mv.release_date between '1988-01-01' and '2009-01-01' order by mv.rating;

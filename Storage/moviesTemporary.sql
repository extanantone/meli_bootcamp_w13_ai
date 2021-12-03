-- Agregar una película a la tabla movies
INSERT INTO movies(title, rating, awards, release_date,legth,genre_id)
VALUES("Iron Man", 8, 2, '2008-03-05 00:00:00', 100, 1);
-- Agregar un género a la tabla genres
INSERT INTO genres(name, ranking, active) VALUES("Superheroes", 13,1);
-- Asociar a la película del punto 1. con el género creado en el punto 2
UPDATE movies SET genre_id = 14 WHERE id=22;
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1
UPDATE actors SET favorite_movie_id = 22 WHERE id = 47;
-- Crear una tabla temporal copia de la tabla movies
CREATE TEMPORARY TABLE temporary_movies ( SELECT * FROM movies );
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards
DELETE FROM temporary_movies WHERE awards < 5;
-- Obtener la lista de todos los géneros que tengan al menos una película
SELECT name FROM genres WHERE id IN ( SELECT genre_id FROM movies GROUP BY genre_id );
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards
SELECT first_name FROM actors WHERE favorite_movie_id IN ( SELECT id FROM movies WHERE awards > 3 );
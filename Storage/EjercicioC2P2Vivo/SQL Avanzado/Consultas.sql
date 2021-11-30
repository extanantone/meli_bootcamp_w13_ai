SET SQL_SAFE_UPDATES = 0;
-- Agregar una película a la tabla movies.
INSERT INTO movies_db.movies(created_at, title, rating,
awards, release_date, length) VALUES
(CURRENT_DATE, 'Inseption', 8.8,
4, '2010-07-08', 228);

-- Agregar un género a la tabla genres.
INSERT INTO movies_db.genres(created_at, name, ranking, active) VALUES
(CURRENT_DATE, 'Policial',13, true);

-- Asociar a la película del punto 1. con el género creado en el punto 2.
UPDATE movies_db.movies SET genre_id=(SELECT LAST_INSERT_ID()), updated_at= CURRENT_DATE WHERE title = 'Inseption';

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE movies_db.actors SET favorite_movie_id=22 WHERE id = 34;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_tmp
SELECT id,created_at,updated_at,title,rating,awards,release_date,length,genre_id
FROM movies_db.movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_db.movies_tmp WHERE awards<5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT * FROM movies_db.genres WHERE id IN (SELECT DISTINCT genre_id FROM movies_db.movies WHERE genre_id IS NOT NULL);

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * FROM movies_db.actors WHERE favorite_movie_id IN (SELECT id FROM movies_db.movies WHERE awards>3);

-- Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE movies_db.movies ADD INDEX title_index(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies_db.movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
Si la cantidad de registros fuera mucho mas grande la diferencia de tiempos se notaria más. 
De todos modos no hay mucha diferencia el hacer ilike '%%' de una consulta con o sin indice.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
Se podría crear un indice en la tabla series por titulo, por lo general una persona busca por nombre de la serie mas que por cualquier
otro dato y si se recuerda la primer parte del titulo ayudaría mucho reducir el tiempo con el indice.


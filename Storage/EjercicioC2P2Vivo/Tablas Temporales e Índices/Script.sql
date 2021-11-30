----- Ejercicio 1 ----
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE movies_db.TWD
SELECT e.* FROM movies_db.episodes e
INNER JOIN movies_db.seasons s ON  s.id = e.season_id
INNER JOIN movies_db.series se ON s.serie_id = se.id
WHERE se.title = 'The Walking Dead';

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM movies_db.TWD WHERE number=1;

----- Ejercicio 2 -----
-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo. 
ALTER TABLE movies_db.series ADD INDEX title_index(title);
SHOW INDEX FROM movies_db.series;

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
Por lo general una persona busca por nombre de la serie mas que por cualquier
otro dato y si se recuerda la primer parte del titulo ayudaría mucho reducir el tiempo con el indice.
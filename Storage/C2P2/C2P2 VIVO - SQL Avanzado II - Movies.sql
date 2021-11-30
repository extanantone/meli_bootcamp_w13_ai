use movies_db;

-- EJ 01
INSERT INTO movies 
VALUES (22, null, null, 'The Lord of the Rings: The Fellowship of the Ring', 8.8, 12, LOCALTIME, 258, 8);

-- EJ 02
INSERT INTO genres
VALUES (13, NULL, NULL, 'Suspenso', 13, 1);

-- EJ 03
UPDATE movies
SET genre_id = 13
WHERE id = 22;

-- EJ 04
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 4;

-- EJ 05
create temporary table moviesTemp
select m.* from movies m;

 select * from moviesTemp;
 
 -- EJ 06
 DELETE FROM moviesTemp
 where awards < 5;
 
 -- EJ 07
 SELECT * FROM genres
 WHERE id IN (
 SELECT genre_id 
 FROM movies);
 
 -- EJ 08
 SELECT * FROM ACTORS a
 JOIN MOVIES m
 ON a.favorite_movie_id = m.id
 WHERE m.awards > 3; 
 
 -- EJ 09
 CREATE INDEX index_title_movies
ON movies (title);

EXPLAIN SELECT * FROM movies
where title like 'titanic';



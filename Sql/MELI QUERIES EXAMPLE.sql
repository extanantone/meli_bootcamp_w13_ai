SELECT * from MOVIES;
SELECT a.first_name, a.last_name, a.rating from ACTORS a;
SELECT title as nombre from series;
SELECT a.first_name, a.last_name from ACTORS a where a.rating>7.5;
SELECT title,rating from Movies m where m.rating>7.5 and m.awards>2;
SELECT title,rating from movies order by rating asc;
SELECT title FROM movies limit 3;
SELECT title,rating from Movies order by rating DESC LIMIT 5;
SELECT * from ACTORS LIMIT 10;
SELECT title, rating from Movies where title='Toy Story';
SELECT * from ACTORS WHERE first_name like 'sam%';
SELECT * from Movies where release_date >='2004-01-01' AND release_date <='2008-12-31';
SELECT title from Movies where rating>3 and awards>1 and  release_date >='1988-01-01' AND release_date <='2009-12-31';
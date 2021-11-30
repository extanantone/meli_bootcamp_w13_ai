use movies_db;

-- EJ 01
select * from movies;

-- EJ 02
select first_name, last_name, rating from actors;

-- EJ 03
select title as Título from series as Series;

-- EJ 04
select first_name, last_name from actors where rating > 7.5;

-- EJ 05
select title, rating, awards from movies where rating > 7.5 and awards > 2;

-- EJ 06
select title, rating from movies order by rating;

-- EJ 07
select title from movies LIMIT 3;

-- EJ 08
select * from movies order by rating desc LIMIT 5;

-- EJ 09
select * from actors LIMIT 10;

-- EJ 10
select title, rating from movies where title = 'Toy Story';

-- EJ 11
select * from actors where first_name like 'Sam%';

-- EJ 12
select title from movies where year(release_date) between 2004 and 2008;

-- EJ 13
select title from movies where rating > 3 and awards > 1 and  year(release_date) between 1988 and 2009 order by rating;
 
CREATE temporary table movies_db.twd 
select e.* from movies_db.series s inner join movies_db.seasons season on season.serie_id=s.id inner join movies_db.episodes e on e.season_id=s.id  where s.title='The Walking Dead';


select e.* from movies_db.series s inner join movies_db.seasons season on season.serie_id=s.id inner join movies_db.episodes e on e.season_id=s.id  where s.title='The Walking Dead' and season.number = 1;


select * from movies_db.twd where season_id in (select id from movies_db.seasons where number=1);


create index index_autors_rating on movies_db.actors(rating);
EXPLAIN SELECT * from movies_db.actors where rating>2 and rating<6;


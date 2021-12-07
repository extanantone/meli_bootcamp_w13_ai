use movies_db;

drop table TWD;

-- Tabla temporal
create temporary table TWD (
	select ep.* from episodes ep
		inner join seasons sea on ep.season_id = sea.id
		inner join series ser on ser.id = sea.serie_id
		where ser.title = "The Walking Dead");

-- episodios de la primera temporada.
select twd.* 
from TWD twd inner join seasons sea 
on sea.id = twd.season_id 
where sea.number = 1;

-- Index
show index from actors;
create index indice_rating on actors (rating);

EXPLAIN select * 
from actors 
where rating = 7.5;

-- alter table actors add index indice_rating (rating);

use movies_db;

-- EJ 01
create temporary table TWD
select e.* from episodes e
 inner join seasons s on  s.id = e.season_id
 inner join series se on s.serie_id = se.id
 where se.title = 'The Walking Dead';
 select * from twd;
 
 -- EJ 02
CREATE INDEX index_email_users
ON users (email);

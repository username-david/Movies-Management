drop database movie_webapp;
CREATE DATABASE movie_webapp;

use movie_webapp;

DROP TRIGGER IF EXISTS after_movie_genre_update;
CREATE TRIGGER after_movie_genre_update 
AFTER UPDATE 
ON movie_genre
FOR EACH ROW
delete from genre where id not in (select distinct genre_id from movie_genre);

DROP TRIGGER IF EXISTS after_movie_genre_delete;
CREATE TRIGGER after_movie_genre_delete 
AFTER DELETE 
ON movie_genre
FOR EACH ROW
delete from genre where id not in (select distinct genre_id from movie_genre);
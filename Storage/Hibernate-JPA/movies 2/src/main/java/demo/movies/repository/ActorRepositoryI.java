package demo.movies.repository;

import demo.movies.entity.Genre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import demo.movies.entity.Actor;

import java.util.List;

@Repository
public interface ActorRepositoryI extends CrudRepository<Actor, Long> {


   //Listar todos los actores que tengan declarada una película favorita.
   //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
   //Listar todos los actores que trabajan en la <película recibida por parámetro>
   //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
   //Listar todas las películas que pertenezcan al <género recibido por parámetro>
   //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
   //Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>

    @Query("SELECT a from Actor a ")
    List<Actor> findActor();

    @Query("select distinct actor " +
            "from Actor actor " +
            "join actor.favoriteMovie movie ")
    List<Actor> findActorWhichHaveFavouriteMovies();

}

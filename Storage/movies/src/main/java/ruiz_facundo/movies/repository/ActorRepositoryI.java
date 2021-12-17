package ruiz_facundo.movies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ruiz_facundo.movies.entity.Actor;

@Repository
public interface ActorRepositoryI extends CrudRepository<Actor, Long> {
}

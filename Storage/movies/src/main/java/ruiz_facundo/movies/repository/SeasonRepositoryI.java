package ruiz_facundo.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruiz_facundo.movies.entity.Season;

@Repository
public interface SeasonRepositoryI extends JpaRepository<Season, Long> {
}

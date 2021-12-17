package ruiz_facundo.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruiz_facundo.movies.entity.Series;

@Repository
public interface SeriesRepositoryI extends JpaRepository<Series, Long> {
}

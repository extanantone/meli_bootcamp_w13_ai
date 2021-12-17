package ruiz_facundo.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ruiz_facundo.movies.entity.Genre;

@Repository
public interface GenreRepositoryI extends JpaRepository<Genre, Long> {
}

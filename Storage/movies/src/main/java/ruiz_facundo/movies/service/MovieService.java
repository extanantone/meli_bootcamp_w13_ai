package ruiz_facundo.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruiz_facundo.movies.repository.*;

@Service
public class MovieService {
    @Autowired
    private ActorRepositoryI repoActors;
    @Autowired
    private EpisodeRepositoryI repoEpisodes;
    @Autowired
    private GenreRepositoryI repoGenres;
    @Autowired
    private MovieRepositoryI repoMovies;
    @Autowired
    private SeasonRepositoryI repoSeasons;
    @Autowired
    private SeriesRepositoryI repoSeries;
}

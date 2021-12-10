package com.bootcamp.tutorials.repository;

import com.bootcamp.tutorials.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ITutorialRepository extends JpaRepository<Tutorial,Long> {

    Optional<Tutorial> findTutorialByTitle(String title);

    Optional<Tutorial> findTutorialByTitleAndDescription(String title, String description);

    Optional<Tutorial> findTutorialById(Long id);

    /**
     * Debe probarse, aún no estoy seguro de lo que hace
     * @return
     */
    Optional<List<Tutorial>> findTutorialsByPublishedTrue();

    /**
     * Debe probarse, aún no estoy seguro de lo que hace
     * @return
     */
    Optional<List<Tutorial>> findTutorialsByTitleContains(String phrase);

}

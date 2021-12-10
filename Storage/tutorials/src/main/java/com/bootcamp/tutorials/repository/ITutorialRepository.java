package com.bootcamp.tutorials.repository;

import com.bootcamp.tutorials.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ITutorialRepository extends JpaRepository<Tutorial,Long> {

    Optional<Tutorial> findTutorialByTitle(String title);

    Optional<Tutorial> findTutorialByTitleAndDescription(String title, String description);

    Optional<Tutorial> findTutorialById(Long id);


    Optional<List<Tutorial>> findTutorialsByPublishedTrue();

    /**
     * Dañado Debe Arreglarse
     * @param word
     * @return
     */
    Optional<List<Tutorial>> findTutorialsByTitleContains(String word);

}

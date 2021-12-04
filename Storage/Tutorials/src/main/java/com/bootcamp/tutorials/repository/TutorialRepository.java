package com.bootcamp.tutorials.repository;

import com.bootcamp.tutorials.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    public List<Tutorial> findTutorialsByStatusTrue();
    public List<Tutorial> findTutorialByTitleContaining(String titleSearchParam);
}

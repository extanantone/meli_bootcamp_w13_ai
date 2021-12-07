package com.bootcamp.tutorials.repository;

import com.bootcamp.tutorials.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ITutorialRepository extends JpaRepository<Tutorial,Long> {

    Tutorial getTutorialByTitle(String title);

}

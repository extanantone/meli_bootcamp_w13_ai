package com.bootcamp.tutorials.service;

import com.bootcamp.tutorials.dto.request.InCreateTutorialDTO;
import com.bootcamp.tutorials.dto.request.InUpdateTutorialDTO;
import com.bootcamp.tutorials.dto.response.TutorialDTO;

import java.util.List;

public interface ITutorialService {

    TutorialDTO createTutorial (InCreateTutorialDTO tutorialInDTO);

    TutorialDTO updateTutorial (InUpdateTutorialDTO tutorialInDTO);

    List<TutorialDTO> getAllTutorials();

    TutorialDTO getTutorialById(Long id);

}

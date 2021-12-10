package com.bootcamp.tutorials.service;

import com.bootcamp.tutorials.dto.request.InCreateTutorialDTO;
import com.bootcamp.tutorials.dto.request.InUpdateTutorialDTO;
import com.bootcamp.tutorials.dto.response.DeleteTutorialsDTO;
import com.bootcamp.tutorials.dto.response.TutorialDTO;

import java.util.List;

public interface ITutorialService {

    TutorialDTO createTutorial (InCreateTutorialDTO tutorialInDTO);

    TutorialDTO updateTutorial (InUpdateTutorialDTO tutorialInDTO);

    List<TutorialDTO> getAllTutorials();

    TutorialDTO getTutorialById(Long id);

    DeleteTutorialsDTO deleteAllTutorials();

    DeleteTutorialsDTO deleteTutorialById(Long id);

    TutorialDTO publishTutorial(Long id);

    TutorialDTO unpublishTutorial(Long id);

    List<TutorialDTO> getPublishedTutorials();

    List<TutorialDTO> getTutorialsThatContain(String word);

}

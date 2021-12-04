package com.bootcamp.tutorials.service;

import com.bootcamp.tutorials.dto.TutorialCreationDTO;
import com.bootcamp.tutorials.dto.TutorialDTO;

import java.util.List;

public interface ITutorialService {
    public TutorialDTO getTutorial(long id);
    public List<TutorialDTO> getAllTutorials();
    public TutorialDTO createTutorial(TutorialCreationDTO tutorialCreationDTO);
    public TutorialDTO updateTutorial(long id, TutorialCreationDTO tutorialCreationDTO);
    public void deleteTutorial(long id);
    public void deleteAllTutorials();
    public List<TutorialDTO> getActiveTutorials();
    public List<TutorialDTO> searchTutorialsByTitle(String titleSearchParam);
}

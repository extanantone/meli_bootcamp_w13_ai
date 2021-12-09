package com.bootcamp.tutorials.service;

import com.bootcamp.tutorials.dto.request.InCreateTutorialDTO;
import com.bootcamp.tutorials.dto.response.TutorialDTO;

public interface ITutorialService {

    TutorialDTO createTutorial (InCreateTutorialDTO tutorialInDTO);

}

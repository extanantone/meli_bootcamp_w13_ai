package com.bootcamp.tutorials.service;

import com.bootcamp.tutorials.dto.request.InCreateTutorialDTO;
import com.bootcamp.tutorials.dto.response.TutorialDTO;
import com.bootcamp.tutorials.entity.Tutorial;
import com.bootcamp.tutorials.exception.tutorialException.TutorialAlreadyExistsException;
import com.bootcamp.tutorials.repository.ITutorialRepository;
import org.springframework.stereotype.Service;

@Service
public class TutorialService implements ITutorialService{

    private final ITutorialRepository repository;

    public TutorialService(ITutorialRepository repository) {
        this.repository = repository;
    }

    @Override
    public TutorialDTO createTutorial(InCreateTutorialDTO tutorialInDTO) {

        var tutorial = repository.findTutorialByTitleAndDescription(tutorialInDTO.getTitle(),
                tutorialInDTO.getDescription());

        if(tutorial.isPresent()){
            throw new TutorialAlreadyExistsException(tutorialInDTO.getTitle());
        }else{
            var response = repository.save(new Tutorial(tutorialInDTO.getTitle(), tutorialInDTO.getDescription()));
            return new TutorialDTO(response.getId(), response.getTitle(), response.getDescription());
        }
    }
}

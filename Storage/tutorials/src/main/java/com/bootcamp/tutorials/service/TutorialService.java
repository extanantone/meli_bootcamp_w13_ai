package com.bootcamp.tutorials.service;

import com.bootcamp.tutorials.dto.request.InCreateTutorialDTO;
import com.bootcamp.tutorials.dto.request.InUpdateTutorialDTO;
import com.bootcamp.tutorials.dto.response.TutorialDTO;
import com.bootcamp.tutorials.entity.Tutorial;
import com.bootcamp.tutorials.exception.tutorialException.NotFoundTutorialException;
import com.bootcamp.tutorials.exception.tutorialException.TutorialAlreadyExistsException;
import com.bootcamp.tutorials.repository.ITutorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Override
    public TutorialDTO updateTutorial(InUpdateTutorialDTO tutorialInDTO) {

        var id = tutorialInDTO.getId();

        var title = tutorialInDTO.getTitle();

        var description = tutorialInDTO.getDescription();

        var tutorial = repository.findTutorialById(id)
                .orElseThrow( () -> new NotFoundTutorialException(id));

        if(!Objects.isNull(title)){
            tutorial.setTitle(title);
        }

        if(!Objects.isNull(description)){
            tutorial.setDescription(description);
        }

        var response = repository.save(tutorial);

        return new TutorialDTO(tutorial.getId(), tutorial.getTitle(), tutorial.getDescription());
    }

    @Override
    public List<TutorialDTO> getAllTutorials() {

        var tutorials = repository.findAll();

        var response = tutorials.stream().map(tutorial ->
                new TutorialDTO(tutorial.getId(), tutorial.getTitle(), tutorial.getDescription()))
                .collect(Collectors.toList());

        return response;
    }

    @Override
    public TutorialDTO getTutorialById(Long id) {

        var tutorial = repository.findTutorialById(id)
                .orElseThrow( () -> new NotFoundTutorialException(id));

        return new TutorialDTO(tutorial.getId(), tutorial.getTitle(), tutorial.getDescription());
    }
}

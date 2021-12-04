package com.bootcamp.tutorials.service;

import com.bootcamp.tutorials.dto.TutorialCreationDTO;
import com.bootcamp.tutorials.dto.TutorialDTO;
import com.bootcamp.tutorials.model.Tutorial;
import com.bootcamp.tutorials.repository.TutorialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorialService implements ITutorialService {

    private final TutorialRepository tutorialRepository;
    private final ModelMapper mapper;

    public TutorialService(TutorialRepository tutorialRepository, ModelMapper mapper) {
        this.tutorialRepository = tutorialRepository;
        this.mapper = mapper;
    }

    @Override
    public TutorialDTO getTutorial(long id) {
        return mapper.map(tutorialRepository.findById(id), TutorialDTO.class);
    }

    @Override
    public List<TutorialDTO> getAllTutorials() {
        return tutorialRepository.findAll().stream()
                .map(t -> mapper.map(t, TutorialDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TutorialDTO createTutorial(TutorialCreationDTO tutorialCreationDTO) {
        return mapper.map(
                tutorialRepository.save(mapper.map(tutorialCreationDTO, Tutorial.class)),
                TutorialDTO.class
        );
    }

    @Override
    public TutorialDTO updateTutorial(long id, TutorialCreationDTO tutorialCreationDTO) {
        // TODO update
        return null;
    }

    @Override
    public void deleteTutorial(long id) {
        tutorialRepository.delete(tutorialRepository.getById(id));
    }

    @Override
    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

    @Override
    public List<TutorialDTO> getActiveTutorials() {
        return tutorialRepository.findTutorialsByStatusTrue().stream()
                .map(t -> mapper.map(t, TutorialDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TutorialDTO> searchTutorialsByTitle(String titleSearchParam) {
        return tutorialRepository.findTutorialByTitleContaining(titleSearchParam).stream()
                .map(t -> mapper.map(t, TutorialDTO.class))
                .collect(Collectors.toList());
    }
}

package com.bootcamp.tutorials.controller;

import com.bootcamp.tutorials.dto.TutorialCreationDTO;
import com.bootcamp.tutorials.dto.TutorialDTO;
import com.bootcamp.tutorials.service.ITutorialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {

    private final ITutorialService tutorialService;

    public TutorialController(ITutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @PostMapping
    public ResponseEntity<TutorialDTO> createTutorial(@RequestBody TutorialCreationDTO tutorialCreationDTO) {
        return new ResponseEntity<>(
                tutorialService.createTutorial(tutorialCreationDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<TutorialDTO>> getALlTutorials() {
        return new ResponseEntity<>(
                tutorialService.getAllTutorials(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorialDTO> getTutorial(@PathVariable long id) {
        return new ResponseEntity<>(
                tutorialService.getTutorial(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorialDTO> updateTutorial(@PathVariable long id, @RequestBody TutorialCreationDTO tutorialCreationDTO) {
        return new ResponseEntity<>(
                tutorialService.updateTutorial(id, tutorialCreationDTO),
                HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllTutorials() {
        tutorialService.deleteAllTutorials();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutorial(@PathVariable long id) {
        tutorialService.deleteTutorial(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/published")
    public ResponseEntity<List<TutorialDTO>> getActiveTutorials() {
        return new ResponseEntity<>(
                tutorialService.getActiveTutorials(),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<TutorialDTO>> searchTutorialsByTitle(@RequestParam String title) {
        return new ResponseEntity<>(
                tutorialService.searchTutorialsByTitle(title),
                HttpStatus.OK
        );
    }
}

package com.bootcamp.tutorials.controller;

import com.bootcamp.tutorials.dto.request.InCreateTutorialDTO;
import com.bootcamp.tutorials.dto.request.InUpdateTutorialDTO;
import com.bootcamp.tutorials.dto.response.DeleteTutorialsDTO;
import com.bootcamp.tutorials.dto.response.TutorialDTO;
import com.bootcamp.tutorials.service.ITutorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    private final ITutorialService tutorialService;

    public TutorialController(ITutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }


    @PostMapping
    public ResponseEntity<TutorialDTO> createTutorial(@Valid @RequestBody InCreateTutorialDTO tutorialIn){
        var response = tutorialService.createTutorial(tutorialIn);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<TutorialDTO> updateTutorial(@Valid @RequestBody InUpdateTutorialDTO tutorialIn){
        var response = tutorialService.updateTutorial(tutorialIn);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TutorialDTO>> getAllTutorials(){
        return ResponseEntity.ok(tutorialService.getAllTutorials());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorialDTO> getTutorialById(@PathVariable Long id){
        return ResponseEntity.ok(tutorialService.getTutorialById(id));
    }

    @DeleteMapping
    public ResponseEntity<DeleteTutorialsDTO> deleteAllTutorials(){
        return ResponseEntity.ok(tutorialService.deleteAllTutorials());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteTutorialsDTO> deleteTutorialById(@PathVariable Long id){
        return ResponseEntity.ok(tutorialService.deleteTutorialById(id));
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity<TutorialDTO> publishTutorial(@PathVariable Long id){
        return ResponseEntity.ok(tutorialService.publishTutorial(id));
    }

    @PutMapping("/unpublish/{id}")
    public ResponseEntity<TutorialDTO> unpublishTutorial(@PathVariable Long id){
        return ResponseEntity.ok(tutorialService.unpublishTutorial(id));
    }

}

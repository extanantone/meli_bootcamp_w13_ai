package com.bootcamp.tutorials.controller;

import com.bootcamp.tutorials.dto.request.InCreateTutorialDTO;
import com.bootcamp.tutorials.dto.request.InUpdateTutorialDTO;
import com.bootcamp.tutorials.dto.response.TutorialDTO;
import com.bootcamp.tutorials.service.ITutorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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


}

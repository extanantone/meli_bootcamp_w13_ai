package com.bootcamp.tutorials.controller;

import com.bootcamp.tutorials.dto.request.InCreateTutorialDTO;
import com.bootcamp.tutorials.dto.response.TutorialDTO;
import com.bootcamp.tutorials.service.ITutorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

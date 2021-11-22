package com.valid.controller;

import com.valid.dto.FinalNoteDto;
import com.valid.dto.StudentNotesDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class NotesController {

    @PostMapping("/notes")
    public FinalNoteDto notes(@Valid @RequestBody StudentNotesDto dto){
        double avg = dto.getSubjects().stream().mapToDouble(s->s.getScore()).average().getAsDouble();
        return new FinalNoteDto(dto.getStudentName(),avg);
    }
}

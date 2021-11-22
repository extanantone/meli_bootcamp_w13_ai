package com.valid.controller;

import com.valid.dto.FinalNoteDto;
import com.valid.dto.StudentNotesDto;
import com.valid.service.IStudentNotesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class NotesController {

    private IStudentNotesService iStudentNotesService;

    public  NotesController(IStudentNotesService iStudentNotesService){
        this.iStudentNotesService = iStudentNotesService;
    }

    @PostMapping("/notes")
    public FinalNoteDto notes(@Valid @RequestBody StudentNotesDto dto){
        return iStudentNotesService.getAverageNote(dto);
    }
}

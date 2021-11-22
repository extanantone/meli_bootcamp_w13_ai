package com.valid.service;

import com.valid.dto.FinalNoteDto;
import com.valid.dto.StudentNotesDto;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface IStudentNotesService {
    FinalNoteDto getAverageNote(StudentNotesDto dto);
}

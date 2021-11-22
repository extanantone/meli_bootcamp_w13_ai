package com.valid.service;

import com.valid.dto.FinalNoteDto;
import com.valid.dto.StudentNotesDto;
import com.valid.exceptions.StudentNotFoundException;
import com.valid.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentNotesService implements IStudentNotesService{

    private IStudentRepository iStudentRepository;

    public StudentNotesService(IStudentRepository iStudentRepository){
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    public FinalNoteDto getAverageNote(StudentNotesDto dto) {
        if(iStudentRepository.findByName(dto.getStudentName()).isEmpty())
            throw new StudentNotFoundException("Not exist student");
        double avg = dto.getSubjects().stream().mapToDouble(s->s.getScore()).average().getAsDouble();
        return new FinalNoteDto(dto.getStudentName(),avg,dto.getSubjects(),"El Alumno Juan ha obtenido un promedio de "+avg);
    }
}

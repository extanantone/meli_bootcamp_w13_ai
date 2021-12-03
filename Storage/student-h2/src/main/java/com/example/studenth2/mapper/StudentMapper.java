package com.example.studenth2.mapper;

import com.example.studenth2.dto.StudentCreationDTO;
import com.example.studenth2.dto.StudentDTO;
import com.example.studenth2.dto.StudentQualificationsDTO;
import com.example.studenth2.model.Student;

public class StudentMapper {

    public static Student studentCreationToStudent(StudentCreationDTO creationDto) {
        Student s = new Student();
        s.setDni(creationDto.getDni());
        s.setName(creationDto.getName());
        s.setLastName(creationDto.getLastName());
        return s;
    }

    public static StudentDTO studentToDto(Student s) {
        StudentDTO dto = new StudentDTO();
        dto.setId(s.getId());
        dto.setDni(s.getDni());
        dto.setName(s.getName());
        dto.setLastName(s.getLastName());
        return dto;
    }

    public static Student studentQualificationsToStudent(StudentQualificationsDTO dto) {
        Student s = new Student();
        s.setId(dto.getId());
        s.setDni(dto.getDni());
        s.setName(dto.getName());
        s.setLastName(dto.getLastName());
        s.setFirstExamQualification(dto.getFirstExamQualification());
        s.setSecondExamQualification(dto.getSecondExamQualification());
        s.setPracticalClassWork(dto.getPracticalClassWork());
        return s;
    }
}

package com.bootcamp.studentapi.service;

import com.bootcamp.studentapi.dto.request.StudentDTO;
import com.bootcamp.studentapi.dto.response.CreatedStudentDTO;
import com.bootcamp.studentapi.entity.Student;
import com.bootcamp.studentapi.exception.studentExceptions.StudentAlreadyExists;
import com.bootcamp.studentapi.exception.studentExceptions.StudentNotFound;
import com.bootcamp.studentapi.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentServiceImpl implements IStudentService {

    final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public CreatedStudentDTO createStudent(StudentDTO studentDTO) {

        var mail = studentDTO.getEmail();

        Student s = studentRepository.getStudentByEmail(mail)
                .orElse(null);

        if(Objects.isNull(s)){
            Student response = studentRepository.save(new Student(studentDTO.getName(),studentDTO.getLastName(),
                    studentDTO.getAge(),studentDTO.getEmail()));
            return new CreatedStudentDTO(response.getIdStudent());
        }else{
            throw new StudentAlreadyExists(mail);
        }

    }
}

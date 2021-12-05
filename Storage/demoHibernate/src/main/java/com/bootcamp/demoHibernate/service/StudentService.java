package com.bootcamp.demoHibernate.service;

import com.bootcamp.demoHibernate.dto.StudentRequestDTO;
import com.bootcamp.demoHibernate.dto.StudentResponseDTO;
import com.bootcamp.demoHibernate.exceptions.StudentExistException;
import com.bootcamp.demoHibernate.model.Student;
import com.bootcamp.demoHibernate.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    ModelMapper mapper = new ModelMapper();

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) throws StudentExistException {
        Student student = mapper.map(studentRequestDTO, Student.class);

        Optional<Student> optionalStudent = studentRepository.findByDni(student.getDni());

        if (optionalStudent.isPresent()) {
            throw new StudentExistException(student.getDni());
        }

        studentRepository.save(student);

        return mapper.map(student, StudentResponseDTO.class);
    }
    @Override
    public List<StudentResponseDTO> getAllStudents(){
        return null;
    }
}

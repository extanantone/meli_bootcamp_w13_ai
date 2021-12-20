package com.mercadolibre.mysqltest.Service;

import com.mercadolibre.mysqltest.Repository.StudentRepository;
import com.mercadolibre.mysqltest.dto.ResponseDTO;
import com.mercadolibre.mysqltest.dto.StudentDTO;
import com.mercadolibre.mysqltest.exception.StudentAlreadyExistException;
import com.mercadolibre.mysqltest.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{
    ModelMapper mapper= new ModelMapper();
    JpaRepository<Student, Long> studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseDTO createStudent(StudentDTO studentDTO) throws StudentAlreadyExistException {
        Student student= mapper.map(studentDTO, Student.class);
        ExampleMatcher exampleMatcher= ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("dni", s);
        if(studentRepository.findBy(student.getDni(), ))
        Student s= studentRepository.save(student);
        return new ResponseDTO("Estudiante agregado", String.valueOf(s.getId()));
    }
}

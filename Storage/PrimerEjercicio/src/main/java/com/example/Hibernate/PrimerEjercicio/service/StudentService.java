package com.example.Hibernate.PrimerEjercicio.service;

import com.example.Hibernate.PrimerEjercicio.DTOs.StudentDTO;
import com.example.Hibernate.PrimerEjercicio.DTOs.StudentResponseDTO;
import com.example.Hibernate.PrimerEjercicio.execption.NotFounExceptionStudent;
import com.example.Hibernate.PrimerEjercicio.model.Student;
import com.example.Hibernate.PrimerEjercicio.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService{

    private final StudentRepository stuRepo;

    ModelMapper mapper = new ModelMapper();



    public StudentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo; 
    }

    @Override
    public StudentResponseDTO setStudent(StudentDTO studentDTO){

        Student student = mapper.map(studentDTO, Student.class);

        stuRepo.save(student);

        return new StudentResponseDTO(student.getId(),"Usuario creado correctamente");


    }
    @Override
    public List<StudentDTO> getStudents(){

        return stuRepo.findAll().stream().map(s->mapper.map(s,StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudens(StudentDTO studentDTO){

        Student student = mapper.map(studentDTO, Student.class);

        stuRepo.findById(studentDTO.getId()).orElseThrow(()-> new NotFounExceptionStudent(student.getId()));

        stuRepo.save(student);
        StudentDTO studentDTO1=  mapper.map(student,StudentDTO.class);

        return studentDTO1;


    }


}

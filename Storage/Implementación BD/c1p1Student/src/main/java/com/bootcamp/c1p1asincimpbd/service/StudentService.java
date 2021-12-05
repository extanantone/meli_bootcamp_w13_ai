package com.bootcamp.c1p1asincimpbd.service;

import com.bootcamp.c1p1asincimpbd.dto.StudentRequestDTO;
import com.bootcamp.c1p1asincimpbd.dto.StudentResponseDTO;
import com.bootcamp.c1p1asincimpbd.exception.StudentExistException;
import com.bootcamp.c1p1asincimpbd.exception.StudentNotFoundException;
import com.bootcamp.c1p1asincimpbd.model.Student;
import com.bootcamp.c1p1asincimpbd.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {
    ModelMapper mapper = new ModelMapper();
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {
        Student student = mapper.map(studentRequestDTO, Student.class);

        Optional<Student> optionalStudent = studentRepository.findByDni(student.getDni());

        if (optionalStudent.isPresent()) {
            throw new StudentExistException(student.getDni());
        }

        studentRepository.save(student);

        return mapper.map(student, StudentResponseDTO.class);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> listStudent = studentRepository.findAll();
        List<StudentResponseDTO> listStudentResponseDTO =
                listStudent
                        .stream()
                        .map(student -> mapper.map(student, StudentResponseDTO.class))
                        .collect(Collectors.toList());
        return listStudentResponseDTO;
    }

    @Override
    public StudentResponseDTO updateStudent(StudentResponseDTO studentResponseDTO) {
        if (!studentRepository.findByDni(mapper.map(studentResponseDTO, Student.class).getDni()).isPresent()) {
            throw new StudentNotFoundException(studentResponseDTO.getDni());
        }
        Optional<Student> student = studentRepository.findByDni(mapper.map(studentResponseDTO, Student.class).getDni());

        studentResponseDTO.setId(student.get().getId());

        studentRepository.save(mapper.map(studentResponseDTO, Student.class));

        return studentResponseDTO;
    }
}

package com.bootcamp.SpringJPA.service;

import com.bootcamp.SpringJPA.dto.CalificationDTO;
import com.bootcamp.SpringJPA.dto.StudentDTO;
import com.bootcamp.SpringJPA.dto.SuccessDTO;
import com.bootcamp.SpringJPA.exception.DuplicateIdException;
import com.bootcamp.SpringJPA.exception.StudentNotFoundException;
import com.bootcamp.SpringJPA.model.Calification;
import com.bootcamp.SpringJPA.model.Student;
import com.bootcamp.SpringJPA.repository.ICalificationRepository;
import com.bootcamp.SpringJPA.repository.IStudentRepository;
import org.hibernate.sql.Select;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService{

    private final IStudentRepository studentRepository;
    private final ICalificationRepository calificationRepository;
    private ModelMapper mapper;

    public StudentService(IStudentRepository studentRepository, ICalificationRepository calificationRepository) {
        this.studentRepository = studentRepository;
        this.calificationRepository = calificationRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public SuccessDTO createStudent(StudentDTO studentDTO) {
        Student student = this.mapper.map(studentDTO, Student.class);
        //Optional<Student> optionalStudent = this.studentRepository.findById(student.getId());

        if(this.studentRepository.existsById(student.getId())){ //chequea si ya existe uno con igual id
            throw new DuplicateIdException(student.getId());
        }

        this.studentRepository.save(student);
        return new SuccessDTO("Se ha creado correctamente el estudiante con id " + student.getId());
    }

    @Override
    public SuccessDTO deleteStudent(Long studentId){
        if (!this.studentRepository.existsById(studentId)) { //chequea si existe el estudiante
            throw new StudentNotFoundException(studentId);
        }

        this.studentRepository.deleteById(studentId);
        return new SuccessDTO("Se ha eliminado correctamente el estudiante con id " + studentId);
    }

    @Override
    public List<StudentDTO> getStudents(){
        List<Student> listStudents = this.studentRepository.findAll();

        List<StudentDTO> listStudentsDTO = listStudents
                .stream()
                .map(s -> this.mapper.map(s, StudentDTO.class))
                .collect(Collectors.toList());

        return listStudentsDTO;
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO){
        Student student = this.mapper.map(studentDTO, Student.class);

        if(!this.studentRepository.existsById(student.getId())){
            throw new StudentNotFoundException(student.getId());
        }

        student = this.studentRepository.save(student); //actualiza los datos

        return this.mapper.map(student, StudentDTO.class);
    }

    @Override
    public SuccessDTO addCalification(CalificationDTO calificationDTO) {
        Long studentId = calificationDTO.getStudentId();
        Optional<Student> optionalStudent = this.studentRepository.findById(studentId);
        if (optionalStudent.isEmpty()) { //chequea si existe el estudiante
            throw new StudentNotFoundException(studentId);
        }
        //Calification calification = this.mapper.map(calificationDTO, Calification.class);
        Calification calification = new Calification();
        calification.setParcial1(calificationDTO.getParcial1());
        calification.setParcial2(calificationDTO.getParcial2());
        calification.setTrabajoIntegrador(calificationDTO.getTrabajoIntegrador());
        calification.setStudent(optionalStudent.get());
        this.calificationRepository.save(calification);

        return new SuccessDTO("Se han agregado correctamente nuevas calificaciones para el estudiante con ID " + studentId);
    }

    @Override
    public List<CalificationDTO> getCalifications(Long studentId){
        if (!this.studentRepository.existsById(studentId)) { //chequea si existe el estudiante
            throw new StudentNotFoundException(studentId);
        }

        List<Calification> listAllCalifications = this.calificationRepository.findAll();
        List<Calification> listCalification = listAllCalifications.stream()
                                                .filter(x -> x.getStudent().getId().equals(studentId))
                                                .collect(Collectors.toList());
        List<CalificationDTO> listCalificationDTO = listCalification.stream()
                                                        .map(s -> this.mapper.map(s, CalificationDTO.class))
                                                        .collect(Collectors.toList());

        return listCalificationDTO;
    }
}

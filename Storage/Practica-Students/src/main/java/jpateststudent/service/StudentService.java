package jpateststudent.service;

import jpateststudent.dto.StudentDTO;
import jpateststudent.model.Student;
import jpateststudent.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentService {
    private final StudentRepository stdRepo;

    public StudentService(StudentRepository stdRepo) {
        this.stdRepo = stdRepo;
    }

    public StudentDTO addStudent(StudentDTO studentDTO){
        Student student = new Student(studentDTO.getId(),studentDTO.getDni(),studentDTO.getName(),studentDTO.getLastName());
        if(stdRepo.findById(studentDTO.getId()).isPresent()){
            throw new RuntimeException("El estudiante ya existe");
        }
        Student std = stdRepo.save(student);
        return(new StudentDTO(std.getId(), std.getDni(),std.getName(),std.getLastName()));
    }

    public StudentDTO updateStudent(StudentDTO studentDTO){
        Student student = new Student(studentDTO.getId(),studentDTO.getDni(),studentDTO.getName(),studentDTO.getLastName());
        if(stdRepo.findById(studentDTO.getId()).isEmpty()){
            throw new RuntimeException("El estudiante no existe");
        }
        Student std = stdRepo.save(student);
        return(new StudentDTO(std.getId(), std.getDni(),std.getName(),std.getLastName()));
    }

    public List getStudents(){
        return stdRepo.findAll().stream()
                .map(s -> new StudentDTO(s.getId(), s.getDni(),s.getName(),s.getLastName())).collect(Collectors.toList());
    }

    public void deleteStudents(long id){
        stdRepo.deleteById(id );

    }

}

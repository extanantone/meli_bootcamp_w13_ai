package jpateststudent.service;

import jpateststudent.dto.StudentDTO;
import jpateststudent.model.Student;
import jpateststudent.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService
{
    private final StudentRepository stdRepo;

    public StudentService(StudentRepository stdRepo)
    {
        this.stdRepo = stdRepo;
    }

    public StudentDTO addStudent(StudentDTO studentDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Student student = new Student(studentDTO.getId(), studentDTO.getDni(), studentDTO.getName(), studentDTO.getLastName());
        if (stdRepo.existsById(student.getId()))
        {
            throw new RuntimeException("El estudiante ya existe");
        }
        stdRepo.save(student);
        return (modelMapper.map(student, StudentDTO.class));
    }

    public StudentDTO updateStudent(StudentDTO studentDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Student student = new Student(studentDTO.getId(), studentDTO.getDni(), studentDTO.getName(), studentDTO.getLastName());
        if (!stdRepo.existsById(student.getId()))
        {
            throw new RuntimeException("El estudiante no existe");
        }
        stdRepo.save(student);
        return (modelMapper.map(student, StudentDTO.class));
    }

    public List<StudentDTO> getStudents()
    {
        ModelMapper modelMapper = new ModelMapper();
        return stdRepo.findAll().stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }
}

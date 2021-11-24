package com.meli.obtenerdiploma.dao;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDaoTest {

    private static List<StudentDTO> dtos;

    private static IStudentDAO studentDAO = new StudentDAO();

    private static IStudentRepository studentRepository = new StudentRepository();

    @BeforeAll
    public static void setup(){
        dtos =studentRepository.findAll().stream().collect(Collectors.toList());
    }


    @AfterEach
    public void reset(){
        for(StudentDTO dto:dtos){
            if(!studentDAO.exists(dto)){
                studentDAO.save(dto);
            }
        }
    }

    @Test
    public void shouldBeFindExistDao(){
        StudentDTO dto = studentDAO.findById(1l);
        assertNotNull(dto);
        assertEquals(dto.getStudentName(),"Juan");
        assertEquals(dto.getSubjects().size(),3);
        assertTrue(dto.getSubjects().stream().filter(d->d.getName().equals("Matemática") && d.getScore()==9).findFirst().isPresent());
    }

    @Test
    public void shouldBeDeleteExist(){
        try {
            studentDAO.delete(1l);
            Set<StudentDTO> ex = studentRepository.findAll();
            assertEquals(ex.size(),1);
        }catch (Exception e){
            fail();
        }
    }

    @Test
    public void shouldBeAddNewUser(){
        try{
            studentDAO.save(new StudentDTO(3l,"Juan2","",0.0,List.of()));
            Set<StudentDTO> students = studentRepository.findAll();
            assertEquals(students.size(),3);
            assertTrue(students.stream().filter(s->s.getId()==3l).findFirst().isPresent());
            studentDAO.delete(3l);
        }catch (Exception e){
            fail();
        }
    }

    @AfterAll
    public static void next(){
        for (StudentDTO d: dtos) studentDAO.delete(d.getId());
        for (StudentDTO d: dtos) studentDAO.save(d);
    }

}

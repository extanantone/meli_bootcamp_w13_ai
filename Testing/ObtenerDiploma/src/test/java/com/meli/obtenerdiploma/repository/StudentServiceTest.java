package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO dao;

    @Mock
    private IStudentRepository repository;

    @InjectMocks
    private StudentService service;


    @Test
    public void shouldBeFindExistUser(){
        StudentDTO dto = new StudentDTO(1l,"Juan","",0.0, List.of());
        Mockito.when(dao.findById(1l)).thenReturn(dto);
        StudentDTO result = service.read(1l);
        assertNotNull(result);
        assertEquals(result,dto);
        Mockito.verify(dao,Mockito.times(1)).findById(Mockito.anyLong());
    }


    @BeforeEach
    public void clarMock(){
        Mockito.reset(dao);
    }


    @Test
    public void shouldntFindUnexistUser(){
        Mockito.when(dao.findById(2l)).thenThrow(StudentNotFoundException.class);
        assertThrows(StudentNotFoundException.class,()->service.read(2l));
        Mockito.verify(dao,Mockito.times(1)).findById(Mockito.anyLong());
    }

    @Test
    public void shouldFindExistUser(){
        //Mockito.when(dao.save(new StudentDTO(4l,"","",0.0,List.of())))
        assertDoesNotThrow(()->service.update(new StudentDTO(4l,"","",0.0,List.of())));
        Mockito.verify(dao,Mockito.times(1)).save(Mockito.any(StudentDTO.class));
    }

    @Test
    public void shouldAddUser(){
        service.create(new StudentDTO());
        Mockito.verify(dao,Mockito.times(1)).save(Mockito.any(StudentDTO.class));
    }

    @Test
    public void shouldBeUpdateUser(){
        service.update(new StudentDTO());
        Mockito.verify(dao,Mockito.times(1)).save(Mockito.any(StudentDTO.class));
    }

    @Test
    public void shouldBeDeleteUser(){
        service.delete(48l);
        Mockito.verify(dao,Mockito.times(1)).delete(48l);
    }


    @Test
    public void ShouldBeReturnAllUsers(){
        Set<StudentDTO> dtos = Set.of(new StudentDTO());
        Mockito.when(repository.findAll()).thenReturn(dtos);
        Set<StudentDTO> result = service.getAll();
        assertEquals(dtos,result);
    }

}

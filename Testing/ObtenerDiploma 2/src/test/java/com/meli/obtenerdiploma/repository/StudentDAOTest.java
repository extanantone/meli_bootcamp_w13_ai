package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    @InjectMocks
    StudentDAO dao;

    @Test
    void saveValidStudent() {
        SubjectDTO subjectDTO1 = new SubjectDTO("Lengua", 7D);
        SubjectDTO subjectDTO2 = new SubjectDTO("Matemática", 5D);
        List<SubjectDTO> subjectDTOList = new LinkedList<>();
        subjectDTOList.add(subjectDTO1);
        subjectDTOList.add(subjectDTO2);

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "Juancito", 6D, subjectDTOList);
    }

    @Test
    void delete() {
    }

    @Test
    void exists() {
    }

    @Test
    void findById() {
    }
}
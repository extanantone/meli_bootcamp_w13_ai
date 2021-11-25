package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {
    private final StudentDAO studentDAO = new StudentDAO();

    @Test
    void saveStudentDoesNotExist() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(22L);

        // Act
        studentDAO.save(studentDTO);

        // Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    void saveStudentDoesExist() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);

        // Act
        studentDAO.save(studentDTO);

        // Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    void deleteStudentDoesExist() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(4L);
        studentDAO.save(studentDTO);

        // Act
        studentDAO.delete(studentDTO.getId());

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertFalse(studentDAO.exists(studentDAO.findById(studentDTO.getId()))),
                () -> Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(studentDTO.getId()))
        );
    }

    @Test
    void deleteStudentDoesNotExist() {
        // Arrange
        Long id = 6L;

        // Act
        studentDAO.delete(id);

        // Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.delete(id));
    }
}

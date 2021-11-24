package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.FactoryStudents;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class StudentDAOTest {

    IStudentDAO studentRepository = new StudentDAO();

    FactoryStudents factoryStudents = new FactoryStudents();

/*
    If I want to create a new user, I need to use the delete method.
    But, if I want to use delete method, I need to use findById method.
    Then, I must build first the tests for find a user by his id.
 */
    @Test
    @DisplayName("Found student by id Test")
    void shouldToFindTheStudent() {

        // Arrange
//        returns a student identical to the stored student with id 1 by default.
        StudentDTO expect = factoryStudents.getValidStudent();

        // Act
        StudentDTO current = studentRepository.findById(1L);

        // Assert
        Assertions.assertEquals(expect,current);

    }

    @Test
    @DisplayName("Not Found student by id Test")
    void shouldNotToFindTheStudent() {

        // Arrange
        long expect = 100;

        // Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentRepository.findById(expect));
    }
}

package com.bootcamp.tutorials.repository;

import com.bootcamp.tutorials.entity.Tutorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class TutorialRepositoryTest {

    @Autowired
    private ITutorialRepository tutorialRepository;

    @Test
    void testCreateTutorial() {
//        Arrange
        Tutorial tutorial = new Tutorial("Tutorial Test","Este es un tutorial de test!!");

//        Act
        var response = tutorialRepository.save(tutorial);

//        Assert
        Assertions.assertEquals(response.getTitle(),tutorial.getTitle());
    }

    @Test
    void testGetTutorialByTitle() {

//        Arrange
        String expected = "Tutorial Test";

//        Act
        var response = tutorialRepository.getTutorialByTitle(expected);

//        Assert
        Assertions.assertEquals(response.getTitle(),expected);
    }
}

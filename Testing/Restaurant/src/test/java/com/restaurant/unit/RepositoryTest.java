package com.restaurant.unit;

import com.restaurant.model.Food;
import com.restaurant.repository.IFoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RepositoryTest {


    @Autowired
    private IFoodRepository repository;

    @Test
    public void shouldFindAExistFoodFood(){
        String name = "Ajos";
        Food f = repository.getFootByName(name);
        assertNotNull(f);
        assertEquals(f.getName(),name);
    }

    @Test
    void shouldntFindUnexistFood(){
        String name = "unknow";
        Food f = repository.getFootByName(name);
        assertNull(f.getName());
    }


}

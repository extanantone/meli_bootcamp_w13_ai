package com.restaurant.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.model.Food;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Repository
public class FoodRepository implements IFoodRepository{

    private List<Food> foods;

    public FoodRepository(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("food.json")));
            String ln;
            String result = "";
            while ((ln = in.readLine()) != null) result=result+ln;
            in.close();
            foods = new ObjectMapper().readerForListOf(Food.class).readValue(result);
        }catch (Exception e){

        }
    }

    @Override
    public Food getFootByName(String name) {
        return foods.stream().filter(it->it.getName().equals(name)).findFirst().orElse(null);
    }
}

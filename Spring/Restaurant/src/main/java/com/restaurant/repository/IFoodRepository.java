package com.restaurant.repository;

import com.restaurant.model.Food;

public interface IFoodRepository {

    Food getFootByName(String name);

}

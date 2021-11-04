package com.bootcamp.calorias.service;

import com.bootcamp.calorias.dto.DTOCalories;
import com.bootcamp.calorias.dto.DTOPlato;

import java.util.List;

public interface ICaloriesService {
    public List<DTOCalories> getCalories(List<DTOPlato> platos);
}

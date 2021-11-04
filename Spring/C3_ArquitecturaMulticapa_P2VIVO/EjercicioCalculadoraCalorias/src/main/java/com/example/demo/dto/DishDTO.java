package com.example.demo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class DishDTO {
    private String dishName;
    Map<String,Integer> foodAndHeigh;

}

package com.example.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DTOdetailRequest {
    Integer product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}

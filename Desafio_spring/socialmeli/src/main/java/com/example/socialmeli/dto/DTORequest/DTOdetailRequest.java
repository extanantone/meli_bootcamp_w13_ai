package com.example.socialmeli.dto.DTORequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOdetailRequest {
    Integer product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}

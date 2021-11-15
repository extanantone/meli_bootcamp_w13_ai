package com.example.socialmeli.demo.dto.serviceToController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPromoPostCountDTO {

    private int user_id;
    private String user_name;
    private int promoproducts_count;

}
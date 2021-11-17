package com.example.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class DTOResponseAmountUser {
    private Integer user_id;
    private String user_name;
    private Integer followers_count;
}

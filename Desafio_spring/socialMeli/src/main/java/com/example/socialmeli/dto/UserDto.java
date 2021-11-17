package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class UserDto {
    Integer user_id;
    String user_name;
}

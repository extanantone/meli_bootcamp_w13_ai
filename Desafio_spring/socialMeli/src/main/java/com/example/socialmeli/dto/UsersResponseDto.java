package com.example.socialmeli.dto;

import com.example.socialmeli.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_EMPTY)

@AllArgsConstructor
public class UsersResponseDto {
    List<User> userList;
}

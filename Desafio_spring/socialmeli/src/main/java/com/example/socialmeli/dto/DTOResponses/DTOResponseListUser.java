package com.example.socialmeli.dto.DTOResponses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOResponseListUser {
    private Integer user_id;
    private String user_name;
    private ArrayList<DTOUserList> followers;
    private ArrayList<DTOUserList> followees;
}

package com.example.socialmeli.demo.dto.serviceToController;


import com.example.socialmeli.demo.dto.DTOUsuario;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DTOUserFollowersList {

    private int userId;
    private String userName;
    private List<DTOUsuario> followers = new ArrayList<>();


    public void addFollowerToList(DTOUsuario user){

        followers.add(user);
    }

}

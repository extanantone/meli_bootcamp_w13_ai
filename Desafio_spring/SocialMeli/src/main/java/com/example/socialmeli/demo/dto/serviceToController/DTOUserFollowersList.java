package com.example.socialmeli.demo.dto.serviceToController;


import com.example.socialmeli.demo.dto.DTOUsuario;
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
public class DTOUserFollowersList {

    private int user_id;
    private String user_name;
    private List<DTOUsuario> followed = new ArrayList<>();


    public void addFollowerToList(DTOUsuario user){

        followed.add(user);
    }

}

package com.example.socialmeli.demo.dto.serviceToController;


import com.example.socialmeli.demo.dto.UsuarioDTO;
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
public class UserFollowersList {

    private int user_id;
    private String user_name;
    private List<UsuarioDTO> followers = new ArrayList<>();


    public void addFollowerToList(UsuarioDTO user){

        followers.add(user);
    }

}

package com.example.socialmeli.demo.dto.serviceToController;

import com.example.socialmeli.demo.dto.UsuarioDTO;
import com.example.socialmeli.demo.dto.controllerToService.PublicacionPromoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserPromoPostListDTO {

    private int user_id;
    private String user_name;
    private List<PublicacionPromoDTO> posts = new ArrayList<>();


    public void addPostToList(PublicacionPromoDTO p){

        posts.add(p);
    }

}

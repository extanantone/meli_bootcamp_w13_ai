package com.example.socialmeli.demo.dto.serviceToController;

import com.example.socialmeli.demo.dto.controllerToService.DTOPromoPost;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DTOUserPromoPostList {

    private int user_id;
    private String user_name;
    private List<DTOPromoPost> posts = new ArrayList<>();


    public void addPostToList(DTOPromoPost p){

        posts.add(p);
    }

}

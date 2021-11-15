package com.example.socialmeli.demo.dto.serviceToController;


import com.example.socialmeli.demo.dto.controllerToService.ProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostsFromMyFollowedUsersDTO {

    private int userId;
    private List<PostFollowersDTO> posts;


}

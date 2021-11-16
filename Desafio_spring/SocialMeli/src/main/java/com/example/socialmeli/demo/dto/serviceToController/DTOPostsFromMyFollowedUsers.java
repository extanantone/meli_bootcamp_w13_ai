package com.example.socialmeli.demo.dto.serviceToController;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOPostsFromMyFollowedUsers {

    private int userId;
    private List<DTOPostFollowers> posts;


}

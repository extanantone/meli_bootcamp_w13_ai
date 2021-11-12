package com.bootcamp.socialmeli.DTO;

import com.bootcamp.socialmeli.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOFollowers {

    private int userId;
    private String userName;
    private List<DTOUser> followers;

}

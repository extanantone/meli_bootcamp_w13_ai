package com.example.socialmeli.dto;

import com.example.socialmeli.Models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@NoArgsConstructor
@Getter @Setter
public class DTOUserList {
    private Integer user_id;
    private String user_name;

    public DTOUserList(User u){
        this.user_id = u.getUserId();
        this.user_name = u.getUsername();
    }


    public ArrayList<DTOUserList> userToDTO(ArrayList<User> list){
        ArrayList<DTOUserList> listUsersDTO = new ArrayList<>();
        for (User x : list){
            DTOUserList user = new DTOUserList(x);
            listUsersDTO.add(user);
        }
        return listUsersDTO;
    }

}

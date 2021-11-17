
package com.example.socialmeli.dto;

import com.example.socialmeli.Models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Hashtable;
@Getter @Setter
@AllArgsConstructor
public class DTOResponseListUserFollowed {
    private Integer user_id;
    private String user_name;
    private ArrayList<DTOUserList> followed;
}

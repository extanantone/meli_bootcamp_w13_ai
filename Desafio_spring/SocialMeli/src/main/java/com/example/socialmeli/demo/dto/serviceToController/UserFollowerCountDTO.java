package com.example.socialmeli.demo.dto.serviceToController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowerCountDTO {

    private int user_id;
    private String user_name;
    private int followers_count;

}

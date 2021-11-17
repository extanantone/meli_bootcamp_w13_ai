package com.socialmeli.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowsDTO {
    private int user_id;
    private String user_name;
    private int followers_count;
}

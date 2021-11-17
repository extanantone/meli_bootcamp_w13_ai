package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListedFollowedPostsDTO implements Ordenable{
    @JsonProperty("user_id")
    private Long userID;
    private List<ListedPostDTO> posts;
}

package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowedListResponseDTO {
    @JsonProperty("user_id")
    private Long userID;
    @JsonProperty("user_name")
    private String userName;
    private List<UserDTO> followed;
}

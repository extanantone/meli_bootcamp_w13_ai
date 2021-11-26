package com.bootcamp.socialmeli.DTO;

import com.bootcamp.socialmeli.model.Post;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class DTOPromoPost {

    private int userId;
    private String userName;
    private List<Post> posts;
}

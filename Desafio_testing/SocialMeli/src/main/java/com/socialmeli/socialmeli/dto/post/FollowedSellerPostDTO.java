package com.socialmeli.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedSellerPostDTO {
    @Min(value=0, message = "El id de usuario debe ser mayor a cero")
    int user_id;
    List<PostWithoutDiscountDTO> posts;

    public FollowedSellerPostDTO(int user_id) {
        this.user_id = user_id;
        this.posts = new ArrayList<>();
    }
}

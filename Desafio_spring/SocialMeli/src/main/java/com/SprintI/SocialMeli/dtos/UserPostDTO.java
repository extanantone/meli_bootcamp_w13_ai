package com.SprintI.SocialMeli.dtos;

import com.SprintI.SocialMeli.models.Post;
import com.SprintI.SocialMeli.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserPostDTO {
    private int userId;
    private List<PostWithoutDiscountDTO> posts;

    public UserPostDTO(User user) {
        this.userId = user.getId();
        this.posts = user.getPost().stream().map(PostWithoutDiscountDTO::new).collect(Collectors.toList());
    }

}

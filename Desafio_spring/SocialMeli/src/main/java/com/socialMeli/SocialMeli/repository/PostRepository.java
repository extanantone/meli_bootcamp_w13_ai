package com.socialMeli.SocialMeli.repository;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostDTO;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;

public interface PostRepository {
    Post create(Post post);

    PostFollowedDTO productListFollowed(User user);
}

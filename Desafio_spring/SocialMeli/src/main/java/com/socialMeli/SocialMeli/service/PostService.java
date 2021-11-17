package com.socialMeli.SocialMeli.service;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostDTO;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;

public interface PostService {
    Post create(Post post);
    PostFollowedDTO productListFollowed(User user);
    PostFollowedDTO productListFollowed(User user, String date_desc);
}

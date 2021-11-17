package com.socialMeli.SocialMeli.repository;

import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.User;
import com.socialMeli.SocialMeli.postDTO.PostDTO;
import com.socialMeli.SocialMeli.postDTO.PostFollowedDTO;
import com.socialMeli.SocialMeli.postDTO.PromoPostDTO;
import com.socialMeli.SocialMeli.postDTO.PromoProductsCountDTO;

public interface PostRepository {
    Post create(Post post);
    Post create(PromoPostDTO post);

    PostFollowedDTO productListFollowed(User user);

    PromoProductsCountDTO promoProductsCount(User user);
}

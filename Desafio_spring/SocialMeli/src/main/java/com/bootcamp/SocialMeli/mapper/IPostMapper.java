package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.PostDTO;
import com.bootcamp.SocialMeli.model.Post;

public interface IPostMapper {
    Post postDTOToPost (PostDTO postDTO);
}

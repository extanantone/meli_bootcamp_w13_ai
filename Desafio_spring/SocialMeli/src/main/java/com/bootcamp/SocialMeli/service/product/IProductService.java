package com.bootcamp.SocialMeli.service.product;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.dto.product.*;

public interface IProductService {
    ResponseDTO post(PostDTO postDTO);

    ProductFollowedListDTO followedList(int userId, String order);
}
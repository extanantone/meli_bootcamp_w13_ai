package com.sprint.SocialMeli.dto.out;

import com.sprint.SocialMeli.dto.out.PromoPostDtoOut;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter

public class PromoPostList {
    int user_id;
    String user_name;
    List<PromoPostDtoOut> posts;
}

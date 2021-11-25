package com.SocialMeli.SocialMeli.dto;

import com.SocialMeli.SocialMeli.model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostSellerDTO {
    private int user_id;
    private List<PostDTO> posts = new ArrayList<>();
    public PostSellerDTO(int user_id) {
        this.user_id = user_id;
    }


}

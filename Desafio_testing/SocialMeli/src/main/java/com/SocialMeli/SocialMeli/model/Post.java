package com.SocialMeli.SocialMeli.model;

import com.SocialMeli.SocialMeli.dto.PostDTO;
import com.SocialMeli.SocialMeli.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int user_id;
    private int id_post;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;

    private List<Post> listPosts = new ArrayList<Post>();

}
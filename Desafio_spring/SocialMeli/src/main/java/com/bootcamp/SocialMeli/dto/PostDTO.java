package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.Detail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int idUser;
    private int idPost;
    private LocalDate date;
    private DetailDTO detail;
    private int category;
    private double price;
}

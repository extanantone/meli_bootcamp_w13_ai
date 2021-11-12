package com.sprint.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class PostDtoIn {
    int user_id;
    int id_post;
    String date;
    DetailPostDto detail;
    int category;
    double price;
}

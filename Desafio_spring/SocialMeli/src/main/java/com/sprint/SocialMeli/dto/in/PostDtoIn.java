package com.sprint.SocialMeli.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint.SocialMeli.dto.DetailPostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class PostDtoIn {
    int user_id;
    int id_post;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    LocalDate date;
    DetailPostDto detail;
    int category;
    double price;
}

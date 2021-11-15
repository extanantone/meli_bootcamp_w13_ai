package com.example.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id_post")
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    @JsonProperty("detail")
    private DetailDTO detailDTO;
    private int category;
    private double price;
}

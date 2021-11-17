package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
public class PostDTO implements Serializable {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) int userId;
    int idPost;
    @JsonFormat(pattern = "dd-MM-yyyy") LocalDate date;
    ProductDetailDTO detail;
    int category;
    double price;
    boolean hasPromo;
    double discount;
}

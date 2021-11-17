package com.socialMeli.SocialMeli.postDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialMeli.SocialMeli.model.Post;
import com.socialMeli.SocialMeli.model.ProductDetails;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PromoPostInDTO {
    private Integer user_id;
    private Integer id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDetails detail;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}

package com.bootcamp.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate publishDate;
    private PostProduct productOnSale;
    private Integer category;
    private Double price;
}

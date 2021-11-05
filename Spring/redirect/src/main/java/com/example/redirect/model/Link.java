package com.example.redirect.model;

import com.example.redirect.dto.LinkDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Link {
    String url;
    String pass;
    Integer metrics;
    Integer id;
}

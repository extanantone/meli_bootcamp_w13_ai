package com.example.redirect.model;

import com.example.redirect.dto.LinkDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Link {
    String url;
    String pass;
    Integer metrics;
    Integer id;
}

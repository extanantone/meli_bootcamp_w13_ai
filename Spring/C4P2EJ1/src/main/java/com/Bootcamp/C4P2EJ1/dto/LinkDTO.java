package com.Bootcamp.C4P2EJ1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private String url;
    private Integer id;
    private String password;
    private Integer contador;

}

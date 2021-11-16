package com.bootcamp.link_tracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Link {

    private Integer id;
    private String url;
    private Integer cantRedirecciones;
    private String password;

}

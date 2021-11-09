package com.SpringRecapitulando.LinkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private int id;
    private String url;
    private int views;
    private boolean validate;
    private String password;
}

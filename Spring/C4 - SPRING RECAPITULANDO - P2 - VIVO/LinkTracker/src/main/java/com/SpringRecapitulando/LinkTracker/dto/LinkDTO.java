package com.SpringRecapitulando.LinkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class LinkDTO {
    private int id;
    private String url;
    private int views;
    private boolean validate;
}

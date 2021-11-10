package com.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class CreateLinkInDTO {

    private String url;

    public CreateLinkInDTO() {}
}

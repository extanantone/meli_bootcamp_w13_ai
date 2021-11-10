package com.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class CreateLinkOutDTO extends CreateLinkInDTO{

    private long linkId;

    private String url;

    public CreateLinkOutDTO() {}
}

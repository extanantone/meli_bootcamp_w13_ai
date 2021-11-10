package com.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateLinkPassInDTO extends CreateLinkInDTO{

    private String pass;

    public CreateLinkPassInDTO() {
    }

    public CreateLinkPassInDTO(String url,String pass) {
        super(url);
        this.pass = pass;
    }
}

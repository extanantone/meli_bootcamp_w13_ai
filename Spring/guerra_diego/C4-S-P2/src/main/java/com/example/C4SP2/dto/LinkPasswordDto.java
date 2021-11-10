package com.example.C4SP2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class LinkPasswordDto extends LinkDto{

    private String password;

    public LinkPasswordDto() {
    }

    public LinkPasswordDto(int id, String url, String password) {
        super(id, url);
        this.password = password;
    }
}

package com.example.C4SP2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class LinkDto {

    private int id;
    private String url;

    public LinkDto() {
    }

    public LinkDto(int id, String url) {
        this.id = id;
        this.url = url;
    }
}

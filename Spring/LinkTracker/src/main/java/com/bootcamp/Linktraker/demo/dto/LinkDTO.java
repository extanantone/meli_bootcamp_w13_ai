package com.bootcamp.Linktraker.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {

    private String uRL;
    private String pass;
    private long id;

    public LinkDTO(String url, String pass) {
        this.uRL = url;
        this.pass = pass;
    }
}

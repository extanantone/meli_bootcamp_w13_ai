package com.link.link.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDTO {
    private Integer linkId;
    private String link;
    private String password;
    private boolean validate;
    private Integer count;

    public LinkDTO() {
        this.count = 0;
    }

    public void sumCount(){
        this.count++;
    }
}

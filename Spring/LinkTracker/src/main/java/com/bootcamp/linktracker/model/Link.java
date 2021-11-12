package com.bootcamp.linktracker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link {

    private Integer id;
    private String linkURL;
    private int visitsCount;
    private boolean isActive;

    public Link(String linkURL) {
        this.linkURL = linkURL;
        this.visitsCount = 0;
        this.isActive = true;
    }
}

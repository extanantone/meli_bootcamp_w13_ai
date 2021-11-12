package com.bootcamp.linktracker.dto;

import com.bootcamp.linktracker.model.Link;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDTO {

    private Integer id;
    private String linkURL;
    private int visitsCount;
    private boolean isActive;

    public LinkDTO(Link link) {
        this.id = link.getId();
        this.linkURL = link.getLinkURL();
        this.visitsCount = link.getVisitsCount();
        this.isActive = link.isActive();
    }
}

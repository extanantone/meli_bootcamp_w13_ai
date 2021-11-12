package com.bootcamp.linktracker.dto;

import com.bootcamp.linktracker.model.Link;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkCreationResDTO {

    private Integer id;

    public LinkCreationResDTO(Integer id) {
        this.id = id;
    }

    public LinkCreationResDTO(Link link) {
        this.id = link.getId();
    }
}

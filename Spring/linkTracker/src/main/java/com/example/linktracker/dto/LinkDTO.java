package com.example.linktracker.dto;

import com.example.linktracker.model.Link;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {

    private String url;
    private Integer id;

    public LinkDTO(Link link) {
        this.url = link.getUrl();
        this.id = link.getId();
    }
}

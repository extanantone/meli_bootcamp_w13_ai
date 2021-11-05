package com.example.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private String url;
    private String password;
    private Long visits;
    private Boolean active;

    public Link(String url, String password) {
        this.url = url;
        this.password = password;
    }

    public void incrementVisits(Long value) {
        this.visits += value;
    }
}

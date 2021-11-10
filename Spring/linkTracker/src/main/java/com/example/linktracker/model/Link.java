package com.example.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String url;
    private String password;
    private Integer id;
    private Integer count = 0;
    private Boolean status = true;

    public void addCount() {
        this.count++;
    }
}

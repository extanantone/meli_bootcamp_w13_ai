package com.bootcamp.linkTracker.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    private int id;
    private String url;
    private boolean active;
    private String password;
    private int redirectNumber;
}

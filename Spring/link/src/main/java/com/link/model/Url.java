package com.link.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Url {
    private int id;
    private String url;
    private boolean active;
    private int redirectNumber;

}

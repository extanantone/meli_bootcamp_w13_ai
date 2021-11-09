package com.bootcamp.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Link {
    String link;
    String password;
    long count;
    boolean disable;
}

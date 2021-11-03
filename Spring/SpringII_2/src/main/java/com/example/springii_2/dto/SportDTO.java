package com.example.springii_2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SportDTO implements Serializable {

    private String name;
    private Integer nivel;
}

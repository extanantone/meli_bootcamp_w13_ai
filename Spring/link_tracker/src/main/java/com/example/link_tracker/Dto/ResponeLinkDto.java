package com.example.link_tracker.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponeLinkDto {
    String url;
    Integer id;
    Boolean valid;
}

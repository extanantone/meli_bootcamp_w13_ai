package com.link.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DtoUrlMetrics {
    private String url;
    private int redirects;
}

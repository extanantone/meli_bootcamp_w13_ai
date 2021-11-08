package com.bootcamp.linkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UrlMetricsDTO {
    private String url;
    private int redirects;
}

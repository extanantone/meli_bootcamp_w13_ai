package com.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LinkMetricsDTO {
    String link;
    long count;
}

package com.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class LinkStatisticsDTO {

    private long longId;

    private long redirecs;

    public LinkStatisticsDTO() {}
}

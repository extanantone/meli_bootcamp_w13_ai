package com.example.c4_man_excep_vivo_p1.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LinkDTO
{
    private Integer linkId;
    private boolean valid;
    private String userLink;
}

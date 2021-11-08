package com.example.c4_manejo_excep_vivo_p1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EntradaBlogDTO
{
    private Long id;
    private String title;
    private String authorName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate pubDate;
}

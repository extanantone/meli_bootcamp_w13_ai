package com.example.c4_man_excep_vivo_p1.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Link
{
    public static Integer linkIds = 0;

    public Link()
    {
       linkIds++;
    }

    private Integer linkId;
    private String userLink;
    private boolean valid;
    private Integer clickCounter = 0;
    private String password;

    public void increaseCounter()
    {
        clickCounter++;
    }
}

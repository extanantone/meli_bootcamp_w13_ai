package com.C4P2VIVO.LinkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LinkDTO {
    private Integer linkId;
    private String link;
    private String password;
    private Integer count;
    private Boolean active;

    public void sumCount(){
        count++;
    }
}

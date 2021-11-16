package com.mercadolibre.coderesponse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private String linkID;
    private int contador;
    private String link;
    private String pass;
}

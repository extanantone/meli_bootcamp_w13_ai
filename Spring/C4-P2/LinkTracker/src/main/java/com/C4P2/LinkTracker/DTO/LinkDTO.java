package com.C4P2.LinkTracker.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
    private String url;
    private int cantVisitas;
    private boolean esValido;
}

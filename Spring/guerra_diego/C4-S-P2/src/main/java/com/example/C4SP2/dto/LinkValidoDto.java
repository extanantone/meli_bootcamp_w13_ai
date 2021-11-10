package com.example.C4SP2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LinkValidoDto extends LinkDto{

    private boolean valido;

    public LinkValidoDto(int id, String url, boolean valido) {
        super(id, url);
        this.valido = valido;
    }
}

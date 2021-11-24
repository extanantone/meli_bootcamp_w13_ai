package com.example.linktracker.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Link {
    private Integer linkId;
    private String url;
    private String password;
    private int vecesRedireccionado;
    private boolean esValido;
}

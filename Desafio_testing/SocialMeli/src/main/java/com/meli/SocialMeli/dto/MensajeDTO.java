package com.meli.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MensajeDTO implements Serializable {
    private String response;
    @JsonIgnore
    private int status;

}






package com.bootcamp.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    String code;
    String msg;
}

package com.socialmeli.socialmeli.exceptions.errorDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {
    private String name;
    private String msg;
}

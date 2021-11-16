package com.ejerciciolinktracker.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkInvalidatedException extends RuntimeException {
    private Integer id;

    public LinkInvalidatedException(Integer id){this.id = id;}
}

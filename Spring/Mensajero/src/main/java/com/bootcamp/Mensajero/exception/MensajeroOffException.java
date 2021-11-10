package com.bootcamp.Mensajero.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MensajeroOffException extends RuntimeException{
    String msg;
}

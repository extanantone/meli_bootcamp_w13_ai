package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class División {
    private int a;
    private int b;

    public int ejecutarOperacion() {
        try{
            return b/a;
        }
        catch(Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }
}
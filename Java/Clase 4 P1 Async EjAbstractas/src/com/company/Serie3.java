package com.company;

import java.lang.instrument.IllegalClassFormatException;

public class Serie3<T extends Number> extends SerieEstandar<T>{

    public Serie3(){
        salto = 3.d;
    }
}

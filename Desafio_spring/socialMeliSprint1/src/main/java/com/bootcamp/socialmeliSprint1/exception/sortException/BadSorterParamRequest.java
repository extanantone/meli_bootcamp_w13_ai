package com.bootcamp.socialmeliSprint1.exception.sortException;

public class BadSorterParamRequest extends RuntimeException{

    public BadSorterParamRequest(String order) {
        super("El parametro de ordenamiento recibido:" + order + " contiene un formato incorrecto.");
    }
}

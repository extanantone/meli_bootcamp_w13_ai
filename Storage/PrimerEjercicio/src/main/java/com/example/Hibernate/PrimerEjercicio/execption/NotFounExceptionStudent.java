package com.example.Hibernate.PrimerEjercicio.execption;

public class NotFounExceptionStudent extends RuntimeException {

    public NotFounExceptionStudent(Long id) {
        super("No se encuentra el Studens ID:"+id);
    }
}

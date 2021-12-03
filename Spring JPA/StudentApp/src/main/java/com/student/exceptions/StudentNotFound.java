package com.student.exceptions;

public class StudentNotFound  extends RuntimeException{

    public StudentNotFound(long id){
        super("No existe usuario con id");
    }
}

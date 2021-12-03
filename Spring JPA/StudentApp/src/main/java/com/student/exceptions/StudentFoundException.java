package com.student.exceptions;

public class StudentFoundException extends RuntimeException{

    public StudentFoundException(String dni){
        super("Existe usuario con dni "+dni);
    }

}

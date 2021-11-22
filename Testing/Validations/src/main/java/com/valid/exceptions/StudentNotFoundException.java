package com.valid.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String ms){
        super(ms);
    }

}

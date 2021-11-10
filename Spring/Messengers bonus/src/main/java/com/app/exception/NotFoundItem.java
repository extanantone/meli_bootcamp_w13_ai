package com.app.exception;

public class NotFoundItem extends RuntimeException{

    public NotFoundItem(String ms){
        super(ms);
    }

}

package com.app;

public class SocorristaMoto implements Socorrista<Moto>{

    public SocorristaMoto(){

    }

    @Override
    public void socorrer(Moto moto) {
       System.out.println("Socorriendo moto "+moto.getPatente());
        
    }
    
}

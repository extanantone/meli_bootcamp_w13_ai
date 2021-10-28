package com.app;

public class SocorristaAuto implements Socorrista<Auto>{

    public SocorristaAuto() {
    }

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto");
        
    }
    
}

package com.bootcamp.apiromanos.model;

import java.util.HashMap;
import java.util.Map;

public class DiccionarioRomanos {

    private Map<Integer,String> romanos;

    public DiccionarioRomanos() {
        this.romanos = new HashMap<>();
        llenar();
    }

    private void llenar(){
        romanos.put( 1000, "M");
        romanos.put(900, "CM");
        romanos.put(800, "DCCC");
        romanos.put(700, "DCC");
        romanos.put(600, "DC");
        romanos.put(500, "D");
        romanos.put(400, "CD");
        romanos.put(300, "CCC");
        romanos.put(200, "CC");
        romanos.put(100, "C");
        romanos.put(90, "XC");
        romanos.put(80,"LXXX");
        romanos.put(70,"LXX");
        romanos.put(60,"LX");
        romanos.put(50,"L");
        romanos.put(40, "XL");
        romanos.put(30, "XXX");
        romanos.put(20, "XX");
        romanos.put(10, "X");
        romanos.put(9,"IX");
        romanos.put(8, "VII");
        romanos.put(7, "VII");
        romanos.put(6, "VI");
        romanos.put(5, "V");
        romanos.put(4, "IV");
        romanos.put(3, "II");
        romanos.put(2, "II");
        romanos.put(1, "I");
        romanos.put(0, "");
    }

    public String getRomano(int n){

        String romano = romanos.get(n);

        return romano;
    }

}

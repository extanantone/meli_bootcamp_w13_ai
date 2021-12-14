package com.bootcamp.demo.demo.model;

public class NumeroDecimal {
    Integer decimal;


    public NumeroDecimal(Integer decimal) {
        this.decimal = decimal;
    }

    public Integer getDecimal() {
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }

    public String aRomano(){
        int[] decimales = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanos = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        int decimal = this.decimal;

        StringBuilder resultado = new StringBuilder();

        for(int i=0;i<decimales.length;i++) {
            while(decimal >= decimales[i]) {
                decimal -= decimales[i];
                resultado.append(romanos[i]);
            }
        }

        return String.valueOf(resultado);
    }





}

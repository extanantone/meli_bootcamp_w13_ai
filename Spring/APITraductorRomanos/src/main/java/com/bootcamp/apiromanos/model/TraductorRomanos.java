package com.bootcamp.apiromanos.model;

public class TraductorRomanos {

    private int entero;

    private String romano;

    public TraductorRomanos(int entero) {
        this.entero = entero;
        this.romano = traducir(entero);
    }

    private String traducir(int entero){

        DiccionarioRomanos dr = new DiccionarioRomanos();

        Numero n = new Numero(entero);

        int u = n.getUnidades();

        int d = n.getDecenas() * 10;

        int c = n.getCentenas() * 100;

        int m = n.getMiles() * 1000;

        this.romano = dr.getRomano(m) + dr.getRomano(c) + dr.getRomano(d) + dr.getRomano(u);

        if(n.getMiles()<4 || entero<1){
            return "Entero: " + entero + " , Romano : " + romano;
        }else{
            return "Número fuera de rango";
        }

    }

    public String getRomano() {
        return romano;
    }
}

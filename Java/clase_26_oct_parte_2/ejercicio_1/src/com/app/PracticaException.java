package com.app;

public class PracticaException{
    int a=0;
    int b = 300;

    public PracticaException(){

    }

    public void calcular(){
        try{
            int result = b/a;
        }catch(Exception e){
            System.out.println("Se ha producido un error.");
        }finally{
            throw new IllegalArgumentException("No se puede dividir por cero");
            //System.out.println("Programa finalizado.");
            
        }
    }

    public static void main(String[] args){
        new PracticaException().calcular();
    }
}
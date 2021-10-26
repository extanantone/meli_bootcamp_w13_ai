package com.company;

public class Main {

    public static void main(String[] args) {
	    int a=0;
	    int b=300;

	    try{
			int c= b/a;
		}catch (ArithmeticException e){
			System.out.println("Se ha producido un error no se puede dividir por 0");
		}finally {
			System.out.println("Ejecución final");
		}



    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
	    Animal [] animalitos = new Animal[]{
	    		new Perro(),
				new Gato(),
				new Vaca()
		};

	    for(Animal animal : animalitos){
			System.out.println(">>>>>" + animal.getClass());
	    	animal.emitirSonido();
	    	animal.comer();
		}
    }
}

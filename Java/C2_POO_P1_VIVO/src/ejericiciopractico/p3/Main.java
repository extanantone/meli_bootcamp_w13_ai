package ejericiciopractico.p3;

public class Main {

    public static void main(String[] args) {
        Persona jose = new Persona();
        Persona maria = new Persona("Jose",21,"12345");
        Persona tomas = new Persona("Maria",24,56,"123456",1.5);

//        Persona juan = new Persona("Juan",12);

        System.out.println("los datos de la ultima persona son: ");
        System.out.println(tomas.toString());


    }
}

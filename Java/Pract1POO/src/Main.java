public class Main {
    public static void main(String args[]){

        Persona juan = new Persona();
        Persona daniel = new Persona("Daniel", (short)38, "394857");
        Persona pedro = new Persona("Pedro", (short)20, "18273469",74.2,1.78);

        //Genera error dado que el constructor no existe
        //Persona andres = new Persona("Andrés",(short)5);

        System.out.println(pedro.evaluarPeso());
        if(pedro.esMayor()){
            System.out.println("Es mayor");
        }
        System.out.println(pedro.toString());

    }
}

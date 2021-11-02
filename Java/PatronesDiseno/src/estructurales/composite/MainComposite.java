package estructurales.composite;

public class MainComposite {
    public static void main(String[] args) {

        Nave nave1 = new Nave(1,1,1);
        Nave nave2 = new Nave(1,2,2);
        Nave nave3 = new Nave(1,3,3);
        Nave nave4 = new Nave(1,4,4);
        Nave nave5 = new Nave(1,5,5);
        Nave nave6 = new Nave(1,6,6);
        Nave nave7 = new Nave(1,7,7);

        Flota flotaMenor = new Flota(nave1,nave2,nave3,nave4);

        Flota flotaMayor = new Flota(nave5,nave6,nave7,flotaMenor);

        flotaMayor.moverse(5,5);

        System.out.println(flotaMayor);


    }
}

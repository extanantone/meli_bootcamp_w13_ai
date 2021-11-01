package bootcamp;

public class SocorristaMoto {

    public SocorristaMoto() {
    }

    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo moto " + unaMoto.getPatente());
    }

    @Override
    public String toString() {
        return "Socorrista Moto";
    }
}

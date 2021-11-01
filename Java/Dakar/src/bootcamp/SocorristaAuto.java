package bootcamp;

public class SocorristaAuto {

    public SocorristaAuto() {
    }

    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo auto " + unAuto.getPatente());
    }

    @Override
    public String toString() {
        return "Socorrista Auto";
    }
}

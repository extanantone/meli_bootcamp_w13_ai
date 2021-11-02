package C4.ejercicioIntegradoresP2.dakar;

public class SocorristaAuto implements Socorrer<Auto> {


    @Override
    public void socorrer(Auto o) {
        System.out.println("Socorrer a "+o);
    }
}

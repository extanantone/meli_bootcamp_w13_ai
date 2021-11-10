package Darkar;

public class SocorristaAuto
{
    public void socorrer(Auto unAuto)
    {
            if (unAuto != null)
        System.out.println("Socorriendo auto " + unAuto.getPatente());
        else
            System.out.println("No hay auto");
    }
}

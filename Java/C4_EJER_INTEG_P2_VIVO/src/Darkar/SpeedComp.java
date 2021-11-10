package Darkar;

import java.util.Comparator;

public class SpeedComp implements Comparator<Vehiculo>
{

    @Override
    public int compare(Vehiculo o1, Vehiculo o2)
    {
        return (int) (o1.totalSpeed() - o2.totalSpeed());
    }
}

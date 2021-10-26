package ejericiciopractico.p2;

import java.util.Comparator;

public class ComparadorMapsLong implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Long ind1 = (Long)o1;
        Long ind2 = (Long)o2;

        return (ind1 - ind2)>0?1:0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}

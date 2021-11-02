package estructurales.composite;

public class Nave implements Espacial{
    long posx;
    long posy;
    long id;

    public Nave(long posx, long posy, long id) {
        this.posx = posx;
        this.posy = posy;
        this.id = id;
    }

    public long getPosx() {
        return posx;
    }

    public void setPosx(long posx) {
        this.posx = posx;
    }

    public long getPosy() {
        return posy;
    }

    public void setPosy(long posy) {
        this.posy = posy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void moverse(long posx, long posy) {
        this.posx += posx;
        this.posy += posy;
    }

    @Override
    public String toString() {
        return "\nNave{" +
                "posx=" + posx +
                ", posy=" + posy +
                ", id=" + id +
                '}' ;
    }
}

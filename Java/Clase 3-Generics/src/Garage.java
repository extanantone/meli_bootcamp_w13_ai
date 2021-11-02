import java.util.ArrayList;

public class Garage {
    protected int id;
    protected ArrayList<Garage> garage;

    public Garage(int id, ArrayList garage) {
        this.id = id;
        this.garage = garage;
    }

    public Garage(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ArrayList getGarage() {
        return this.garage;
    }

    public void setGarage(ArrayList garage) {
        this.garage = garage;
    }

    public Garage() {

    }

    public void setId(int id) {
        this.id = id;
    }

}

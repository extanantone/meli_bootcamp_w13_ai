package agencia;

public class Reservation {

    private static int currentId = 0;
    private final int id;
    private Client client;
    private double price;

    public Reservation(Client client, double price) {
        this.id = currentId + 1;
        currentId ++;
        this.client = client;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

package agencia;

public class Product {

    private static int currentId = 0;
    private final int id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.id = currentId + 1;
        currentId ++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

package agencia;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private int id;
    private String name;
    private List<Purchase> purchases;
    private List<Tracker> trackers;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
        purchases = new ArrayList<>();
        trackers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void addPurchases(Purchase purchase) {
        this.purchases.add(purchase);
    }

    public List<Tracker> getTrackers() {
        return trackers;
    }

    public void addTracker(Tracker tracker) {
        this.trackers.add(tracker);
    }
}

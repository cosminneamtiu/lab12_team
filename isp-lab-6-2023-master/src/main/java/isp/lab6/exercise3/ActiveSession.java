package isp.lab6.exercise3;

import java.util.HashMap;

public class ActiveSession {
    private String userName;
    private HashMap<Product, Integer> shoppingChart = new HashMap<>();

    public ActiveSession(String userName) {
        this.userName = userName;
    }

    public void addToChart(Product p, int q) {
        shoppingChart.put(p, q);
    }
}

package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.HashMap;

public class OnlineStore {
    private ArrayList<Product> products = new ArrayList<>();
    private HashMap<String, ActiveSession> sessions = new HashMap<>();

    public void addSession(String userName) {
        System.out.println("Creating session for " + userName);
        sessions.put(userName, new ActiveSession(userName));
    }
}

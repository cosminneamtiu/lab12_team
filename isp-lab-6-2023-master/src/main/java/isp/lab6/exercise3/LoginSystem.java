package isp.lab6.exercise3;

import java.util.HashSet;

public class LoginSystem {
    private HashSet<User> users = new HashSet<>();
    private OnlineStore onlineStore;

    public LoginSystem(OnlineStore onlineStore) {
        this.onlineStore = onlineStore;
    }

    public void register(String name, String pwd) {
        users.add(new User(name, pwd));
    }

    public void login(String name, String pwd) {
        for (User u : users) {
            if (u.getPassword().equals(pwd) && u.getUserId().equals(name)) {
                System.out.println("Login complete!");
                onlineStore.addSession(name);
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }
}

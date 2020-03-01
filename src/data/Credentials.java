package data;

import models.User;
import models.UserRole;

import java.util.ArrayList;
import java.util.List;

public class Credentials {
    private static Credentials instance;

    public static Credentials getInstance() {
        if (instance == null)
            instance = new Credentials();
        return Credentials.instance;
    }

    private List<User> users;

    public Credentials() {
        users = new ArrayList<User>();
        users.add(new User("admin", "admin", UserRole.Admin));
        users.add(new User("bob", "bob", UserRole.User));
    }

    public User getUser(String login) {
        for (User user : this.users) {
            if (user.getLogin().equals(login))
                return user;
        }
        return null;
    }
}

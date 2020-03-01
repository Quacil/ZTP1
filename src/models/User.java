package models;

public class User {
    private final String login;
    private final String password;
    private final UserRole role;

    public User(String login, String password) {
        this(login, password, UserRole.User);
    }

    public User(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return this.role;
    }
}

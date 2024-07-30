package oop.exercise8_interfacesAndAbstractClasses.scenario3;

public abstract class User {
    String login;
    String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public boolean login(String password) {
        if (password.matches(password))
            return true;

        return false;
    }
    public void logOut() {
        System.out.println("Logging out");
    }
}

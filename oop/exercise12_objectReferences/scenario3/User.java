package oop.exercise12_objectReferences.scenario3;

public abstract class User {
    private String login;
    private int password;

    public User(String login, String password) {
        register(login, password);
    }

    public void register(String login, String password) {
        this.login = login;
        this.password = password.hashCode();
    }
    
    public boolean login(String login, String password) {
        if (password.hashCode() == this.password) {
            return true;
        }
        return false;
    }
    public void logout() {
        System.out.println("Logging out");
    }

    public String getLogin() {
        return login;
    }
}

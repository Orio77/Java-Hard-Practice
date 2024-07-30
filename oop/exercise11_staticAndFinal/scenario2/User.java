package oop.exercise11_staticAndFinal.scenario2;

public class User {
    private String name;
    
    public User(String name, String password) {
        this.name = name;
        setPassword(password);
    }

    public String getName() {
        return name;
    }
    public void setPassword(String password) {
        if (password.length() > 8) {
        } else {
            System.out.println("Password doesn't fill the criteria");
        }
    }
}

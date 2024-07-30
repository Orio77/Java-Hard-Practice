package oop.exercise3_encapsulation.scenario1;

public class User {
    private String userName;
    private int password;

    public boolean checkPassword(String password) {
        if (password.hashCode() == this.password)
            return true;

        return false;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password.hashCode();
    }

    public int getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        printPasswordCriteria();
        if (password.length() >= 5) {
            this.password = password.hashCode();
        } else {
            System.out.println("Password must be longer");
        }

    }

    private void printPasswordCriteria() {
        System.out.println("Password requirements:");
        System.out.println("Minimum length: 5");
    }
}

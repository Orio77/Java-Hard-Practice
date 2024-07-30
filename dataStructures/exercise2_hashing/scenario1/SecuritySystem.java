package dataStructures.exercise2_hashing.scenario1;

import java.util.HashMap;
import java.util.Scanner;

public class SecuritySystem {
    private HashMap<String, String> users;

    // TODO Collision Handling System

    public SecuritySystem() {
        this.users = new HashMap<>();
    }
    
    User user1 = new User("lolo", "bolo");

    public int hashpassword(User user) {
        return user.getPassword().hashCode();
    }

    public void registerUser() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Login: "); //we assume there won't be a user with the same login and that the user is not yet registered
            String login = sc.nextLine();
            System.out.println();
            System.out.println("Password");
            String password = sc.nextLine();

            users.put(login, Integer.toString(password.hashCode()));
        }
    }

    public int logUserIn() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Login: "); 
            String login = sc.nextLine();
            if (users.containsKey(login)) {
                System.out.println();
                System.out.println("Password: ");
                String password = sc.nextLine();
                if (Integer.toString(password.hashCode()).equals(users.get(login))) {
                    return 1;
                }
            }
            else {
                System.out.println("No such user registered");
                return 0;
            }
            return 0;
        }
    }
}

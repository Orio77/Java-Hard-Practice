package generics.exericse10.scenario1;

public class User {
    private String name;
    private int userID;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        userID = name.hashCode();
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

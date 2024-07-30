package algorithms.exercise1_sorting.scenario2;

public class Post {
    private String name;
    private int howOld;
    private int ID;

    public Post(String name, int howOld) {
        this.name = name;
        this.howOld = howOld;
        ID = name.hashCode();
    }

    public String getName() {
        return name;
    }

    public int getHowOld() {
        return howOld;
    }
    public int getID() {
        return ID;
    }
}

package algorithms.exercise4_graphs.scenario2;

public class Friendship {
    User user1;
    User user2;
    int likeability;
    
    public Friendship(User user1, User user2, int likeability) {
        this.user1 = user1;
        this.user2 = user2;
        this.likeability = likeability;
    }
    public int getLikeability() {
        return likeability;
    }
    public User getUser1() {
        return user1;
    }
    public User getUser2() {
        return user2;
    }
}


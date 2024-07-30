package algorithms.exercise4_graphs.scenario2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class BFSAlgorithm {
    Network graph;

    public BFSAlgorithm(Network network) {
        graph = network;
    }

    // The algorithm will only compare up to a friend of a friend, no further
    // (User) -> friend -> friend |
    public ArrayList<User> getFriendRecommendations(User user) {
        ArrayList<User> recommendation = new ArrayList<>();
        LinkedList<User> queue = new LinkedList<>();
        HashSet<User> visited = new HashSet<>();

        // fill queue
        for (User friend : user.getFriends()) {
            queue.add(friend);
        }

        
        while (!queue.isEmpty()) {
            User currentFriend = queue.poll();
            if (visited.contains(currentFriend))
                continue;
            else 
                visited.add(currentFriend);

            outerLoop:
            for (String friendInterest : currentFriend.getInterests()) {
                for (String userInterest : user.getInterests()) {
                    if (friendInterest.matches(userInterest)) {
                        recommendation.add(currentFriend);
                        break outerLoop;
                    }
                }
            }
            
            if (currentFriend.getFriends() != null && !currentFriend.getFriends().isEmpty()) {
                for (User friendOfAFriend : currentFriend.getFriends()) {
                    queue.add(friendOfAFriend);
                }
            }
        }
        return recommendation;
    }
}
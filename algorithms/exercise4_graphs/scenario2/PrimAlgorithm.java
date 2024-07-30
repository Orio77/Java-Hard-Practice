package algorithms.exercise4_graphs.scenario2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PrimAlgorithm {
    Network graph;

    public PrimAlgorithm(Network network) {
        graph = network;
    }

    public void execute(User user) {
        HashMap<User, Integer> mutualFriends = new HashMap<>();
        PriorityQueue<User> pQueue = new PriorityQueue<>((user1, user2) -> mutualFriends.get(user2) - mutualFriends.get(user1));
        HashSet<User> addedUsers = new HashSet<>();

        for (User userr : graph.getUsers()) {
            mutualFriends.put(userr, Integer.MAX_VALUE);
        }
        mutualFriends.replace(user, 0);
        pQueue.add(user);

        while (!pQueue.isEmpty()) {
            User currentUser = pQueue.poll();

            if (addedUsers.contains(currentUser))
                continue;
            
            addedUsers.add(currentUser);
            for (User friend : currentUser.getFriends()) {
                int mutualCount = currentUser.getMutualFriendsCount(friend);
                if (!addedUsers.contains(friend) && mutualCount < mutualFriends.get(friend)) {
                    mutualFriends.replace(friend, mutualCount);
                    pQueue.add(friend);
                }
            }
        }
    }
}
 // TODO: execute(User user) - Execute Prim's algorithm starting from the given user. The algorithm should suggest potential friend connections based on mutual friends.

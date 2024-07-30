package algorithms.exercise2_search.scenario2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Network {
    private ArrayList<User> userBase;

    public ArrayList<User> getUserBase() {
        return userBase;
    }

    public ArrayList<User> getFriendRecommendations(User user) {
        
        HashSet<User> visited = new HashSet<>();
        ArrayList<User> recommendations = new ArrayList<>();
        ArrayList<String> userInterests = user.getInterests();
        LinkedList<User> queue = new LinkedList<>();

        queue.add(user);
        visited.add(user);

        while (!queue.isEmpty()) {
            User currUser = queue.poll();

            for (User friend : user.getFriends()) {
                if (!visited.contains(friend)) {
                    queue.add(friend);
                    visited.add(friend);
                }
            }
    
            if (queue.isEmpty())
                return recommendations;
    
            outerFor:
            for (int i = 0; i < userInterests.size(); i++) {
                for (String interest : currUser.getInterests()) {
                    if (interest.matches(userInterests.get(i))) {
                        recommendations.add(currUser);
                        break outerFor;
                    }
                }
            } 
        }
        return recommendations;
    }
}

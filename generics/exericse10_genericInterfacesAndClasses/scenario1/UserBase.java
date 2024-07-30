package generics.exericse10.scenario1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserBase {
    private static UserBase instance;
    private HashMap<Integer, List<String>> userData;

    private UserBase() {
        userData = new HashMap<>();
    }

    public void addData(User user) {
        userData.put(user.getUserID(), new ArrayList<>());
        userData.get(user.getUserID()).add(user.getName());
        userData.get(user.getUserID()).add(Integer.toString(user.getAge()));
    }

    public List<String> getData(int userID) {
        return userData.get(userID);
    }

    public List<List<String>> retrieveAllData() {
        List<List<String>> allData = new ArrayList<>();

        for (List<String> list : userData.values()) {
            allData.add(list);
        }

        return allData;
    }

    public static UserBase getInstance() {
        if (instance == null) {
            instance = new UserBase();
        }
        return instance;
    }
}

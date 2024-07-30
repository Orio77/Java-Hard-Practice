package dataStructures.exercise11_advancedDS.scenario3;

import java.util.ArrayList;
import java.util.LinkedList;

public class DashBoard {
    private ArrayList<User> userBase;
    private int[] buckets;
    private final int HLLParameter =  14;
    LinkedList<String> events;

    public DashBoard() {
        userBase = new ArrayList<>();
        buckets = new int[(int) Math.pow(2, HLLParameter)];
        events = new LinkedList<>();
    }

    public ArrayList<User> getUserBase() {
        return userBase;
    }

    public void simulateUserBase(int numberOfUsers) {
        for (int i = 0; i < numberOfUsers; i++) {
            registerUser(new User("User" + i));
        }
    }

    public void simulateEvents(int number) {
        for (User user : userBase) {
            for (int i = 0; i < number; i++) {
                events.add(user.simulateBehaviour());
            }
        }
    }

    public void showGeneralEventHistory() {
        for (User user : userBase) {
            System.out.println(user.getGeneralHistory());
        }
    }

    public void registerUser(User user) {
        userBase.add(user);
    }

    public int[] getBuckets() {
        return buckets;
    }

    // AI Help - Copilot Guided me with HLL and Bitwise operations
    public void HLL(User user) {
        int usersHashCode = user.getUserId(); // Already hashed in User class
        int index = (usersHashCode >>> (32 - HLLParameter)) % buckets.length;

        int mask = (1 << (32 - HLLParameter)) - 1;
        int remainingHashCode = usersHashCode & mask;

        int q = 32 - Integer.numberOfLeadingZeros(remainingHashCode);

        buckets[index] = Math.max(buckets[index], q);
    }

    // AI Generated
    public double estimate() {
        double rawEstimate = 0;
        int zeroBuckets = 0;

        for (int i = 0; i < buckets.length; i++) {
            rawEstimate += 1.0 / (1 << buckets[i]);
            if (buckets[i] == 0)
                zeroBuckets++;
        }

        rawEstimate = (0.7213 / (1 + 1.079 / buckets.length)) * (buckets.length * buckets.length) / rawEstimate;

        if (rawEstimate <= 2.5 * buckets.length) {
            if (zeroBuckets > 0)
                return buckets.length * Math.log(buckets.length / (double) zeroBuckets);
            else
                return rawEstimate;
        }
        else
            return rawEstimate;
    }

    public boolean isNew(User user) {
        double start = estimate();
        HLL(user);
        double end = estimate();

        if (start != end)
            return true;

        return false;
    }


}

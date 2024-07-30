package dataStructures.exercise2_hashing.scenario3;

import java.util.HashMap;

public class Cache {
    private final int capacity = 30;
    HashMap<Integer, String> cache;

    public Cache() {
        cache = new HashMap<>(capacity);
    }

    public void fillCache(Database database) {
        // database.getDatabase().values().stream().filter(data -> data.) // Database contains data's contents and hashed key, not the Data
        // How to access the data's 'isRecentlyUsed'?
    }
}

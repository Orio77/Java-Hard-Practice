package oop.exercise7_collectionsFramework.scenario3;

import java.util.ArrayList;
import java.util.List;

public class AdvancedCollectionManager extends CollectionManager{
    
    @Override
    public boolean add(Object item) {
        if (!getCollection().contains(item))
            return super.add(item);
        return false;
    }

    @Override
    public boolean remove(Object item) {
        if (getCollection().contains(item))
            return super.remove(item);
        return false;
    }

    @Override
    public Object find(int index) {
        List<Integer> indeces = new ArrayList<>();
        Object item = getCollection().get(index);
        for (int i = 0; i < getCollection().size(); i++) {
            if (getCollection().get(i).equals(item)) {
                indeces.add(i);
            }
        }
        return indeces;
    }

    @Override
    public Object clear() {
        int size = getCollection().size();
        super.clear();
        return size;
    }

    public boolean isEligibleForAddition(Object object) {
        return simulateEligibilityForAdditionCheck(object);
    }

    private boolean simulateEligibilityForAdditionCheck(Object object) {
        return object.hashCode() % 2 == 0;
    }
}

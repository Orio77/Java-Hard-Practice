package oop.exercise13_garbageCollection.scenario3;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollection {
    private List<DemoClass> objects;

    public GarbageCollection() {
        objects = new ArrayList<>();
    }

    public void generateInstances(int number) {
        for (int i = 0; i < number; i++) {
            objects.add(new DemoClass());
            DemoClass.setInstances(DemoClass.getInstances() + 1);
            DemoClass.displayInstanceCount();
        }
    }

    public void nullifyInstances() {
        for (int i = 0; i < objects.size(); i++) {
            if (i % 2 == 0) {
                objects.remove(i);
            }
        }
    }

   

    public static void main(String[] args) {
        GarbageCollection collector = new GarbageCollection();
        collector.generateInstances(100);
        collector.nullifyInstances();

        System.gc();
    }
}

package dataStructures.exercise8_debugging.scenario1;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakDemo {
    static class MemoryEater {
        double[] arr = new double[100000]; // This object takes up a significant amount of memory
    }

    public static void main(String[] args) {
        List<MemoryEater> list = new ArrayList<>();

        while (true) {
            list.add(new MemoryEater());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
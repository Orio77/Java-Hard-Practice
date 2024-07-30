package oop.exercise13_garbageCollection.scenario2;

public class Program {
    private MemoryManager manager;

    public Program() {
        manager = new MemoryManager();
    }

    public void run() {
        int i = 0;
        while (i < 100) {
            simulateDataCreation(10);
            manager.collectGarbage();
            simulateDataCreation(20);
        }
    }
    
    public void simulateDataCreation(int number) {

        for (int i = 0; i < number; i++) {
            manager.allocate(i);
            manager.allocate(i, new Data("content" + i));
        }
    }
}

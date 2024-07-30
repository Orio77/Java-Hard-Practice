package oop.exercise13_garbageCollection.scenario2;

public class MemoryBlock {
    private int size;
    private int usage;
    private Data data;

    public MemoryBlock(int size, Data data) {
        this.size = size;
        this.data = data;
    }

    public void clear() {
        this.data = null;
    }
    
    public Data getData() {
        return data;
    }
    public int getSize() {
        return size;
    }
    public int getUsage() {
        return usage;
    }

    
    public void incrementUsage() {
        usage++;
    }
    
}

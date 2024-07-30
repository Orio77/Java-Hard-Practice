package oop.exercise13_garbageCollection.scenario2;

import java.util.ArrayList;

public class MemoryManager {
    private ArrayList<MemoryBlock> blocks;

    public boolean allocate(int size) {
        return blocks.add(new MemoryBlock(size, null));
    }

    public boolean allocate(int size, Data data) {
        return blocks.add(new MemoryBlock(size, data));
    }

    public void collectGarbage() {
        collectEmpty();
        collectUnused();
    }

    private void collectUnused() {
        for (MemoryBlock block : blocks) {
            if (block.getUsage() < 5) {
                blocks.remove(block);
            }
        }
    }

    private void collectEmpty() {
        for (MemoryBlock block : blocks) {
            if (block.getData() == null)
                blocks.remove(block);
        }
    }

    public ArrayList<MemoryBlock> getBlocks() {
        return blocks;
    }
}

**Advanced Memory Management System**

- **Task 1**: Create a class `MemoryBlock` with properties `size` and `data`. Implement a constructor that sets these properties and a method `clear()` that sets `data` to null.
- **Task 2**: Create a class `MemoryManager` with a property `blocks` (a list of `MemoryBlock` objects). Implement methods `allocate(int size)` that creates a new `MemoryBlock` of a certain size and adds it to `blocks`, and `collectGarbage()` that removes all blocks where `data` is null.
- **Task 3**: Create a class `Program` with a property `memoryManager` (a `MemoryManager` object). Implement a method `run()` that simulates a program run by allocating memory blocks and occasionally clearing them.

**Further practise**:

1. **Advanced Memory Management System – Enhanced Details**:
    - **MemoryBlock**: Extend the `MemoryBlock` class to include a `usage` property that represents how often the block is used. Implement a method `incrementUsage()` that increases this property.
    - **MemoryManager**: Extend the `MemoryManager` class to include a method `collectUnused()` that removes all blocks where `usage` is below a certain threshold.
2. **Memory Management System with Defragmentation – Enhanced Details**:
    - **MemoryManager**: Extend the `MemoryManager` class to include a method `defragment()` that rearranges the blocks in memory to minimize wasted space.
    - **Program**: Extend the `Program` class to occasionally call `defragment()` on the `MemoryManager`.
3. **Customizable Memory Management System – Enhanced Details**:
    - **MemoryManagementStrategy**: Create an interface `MemoryManagementStrategy` with methods `allocate(int size)`, `collectGarbage()`, and `defragment()`. Make `MemoryManager` a class that uses a `MemoryManagementStrategy` to perform these operations.
    - **Program**: Extend the `Program` class to include a method `setStrategy(MemoryManagementStrategy strategy)` that changes the memory management strategy used by the `MemoryManager`.
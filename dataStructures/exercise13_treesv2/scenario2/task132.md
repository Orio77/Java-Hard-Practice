**Refined Scenario 2:** Design a file synchronization tool for cloud storage using appropriate data structures, focusing on Binary Search Trees (BSTs), to represent sorted file lists and handle synchronization.

- **Refined Sprint Tasks:**

1. **Task Refinement:** Implement a Binary Search Tree (BST) data structure to represent sorted lists of files in each folder.
- **Actionable Transparency Instructions:**
    - Understand the concept of BSTs and how they can represent sorted data.
    - Implement a BST, ensuring that each node contains information about a file and the tree maintains its sorted order as files are added or removed.
2. **Task Refinement:** Develop algorithms for detecting changes and synchronizing files using the properties of the BST data structure.
- **Actionable Transparency Instructions:**
    - Implement a method to traverse the BST and detect changes (additions, deletions, modifications) in the file list.
    - Develop a synchronization algorithm that updates the BST structure based on the detected changes.
3. **Task Refinement:** Implement strategies for efficient synchronization of large datasets across devices, focusing on minimizing the number of operations and the amount of data transferred.
- **Actionable Transparency Instructions:**
    - Understand the concept of AVL Trees and how they can be used to keep the BST balanced, ensuring efficient operations.
    - Implement an AVL Tree for the file list, ensuring that the tree rebalances itself after each insertion or deletion.
**Refined Scenario 3: Optimizing File System Search with Efficient Search and Traversal Algorithms**
	**Refined Sprint Tasks:**

  1. **Task Refinement:** Implement Binary Search to rapidly locate files in a large, sorted directory.
    - **Actionable Instructions:**
        - Code the Binary Search algorithm to search through the sorted directory.
        - Test the algorithm with various search queries to ensure it works correctly.
  2. **Task Refinement:** Develop a feature that uses Linear Search to browse files based on specific criteria.
    - **Actionable Instructions:**
        - Implement the Linear Search algorithm to search through an unsorted list of files based on specific criteria.
        - Design the feature in a way that is easy for users to understand and use.
  3. **Task Refinement:** Utilize Depth-First Search (DFS) to traverse and organize files and folders in a directory tree.
    - **Actionable Instructions:**
        - Implement the DFS algorithm to traverse the directory tree and organize files and folders.
        - Test the algorithm with various start points to ensure it traverses and organizes the directory tree correctly.



**class File**
String name;
int size;



**class Directory**
ArrayList<File> fileBase;

+ (File) getFile(String name);
"Binary search"

+ (File) findLargestFile();
"linear search"




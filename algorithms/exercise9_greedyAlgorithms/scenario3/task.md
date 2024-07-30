**Task 1: Define the load of a server as the total processing time of its tasks.**

- Enhanced Instruction: Create a function `calculate_load(server_tasks: List[int]) -> int` that takes a list of tasks (represented by their processing times) assigned to a server and returns the total processing time (load). This function will be used later in the dynamic programming solution.
    
- Potential Input: `[3, 2, 5]`
    
- Desired Output: `10`
    
- Coach Suggestions: Start by initializing a variable `total_load` to 0. Then, iterate over the tasks and add each task's processing time to `total_load`. Finally, return `total_load`.
    

**Task 2: Implement a greedy algorithm that assigns each task to the server with the minimum load.**

- Enhanced Instruction: Create a function `assign_tasks_greedy(servers: List[List[int]], tasks: List[int]) -> List[List[int]]` that takes a list of servers (each represented by a list of tasks) and a list of new tasks. The function should assign each new task to the server with the minimum load (using the `calculate_load` function from Task 1) and return the updated list of servers.
    
- Potential Input: `[[3, 2], [5]], [4, 1]`
    
- Desired Output: `[[3, 2, 1], [5, 4]]`
    
- Coach Suggestions: Iterate over the new tasks. For each task, find the server with the minimum load (you can use a loop or a built-in function like `min`). Add the task to this server's list of tasks. Remember to update the list of servers after assigning each task.
    

**Task 3: Implement a priority queue to efficiently find the server with the minimum load.**

- Enhanced Instruction: Modify the `assign_tasks_greedy` function to use a priority queue (heap) for storing the servers, ordered by their load. This will allow you to efficiently find the server with the minimum load. You can use the `heapq` module in Python.
    
- Potential Input: `[[3, 2], [5]], [4, 1]`
    
- Desired Output: `[[3, 2, 1], [5, 4]]`
    
- Coach Suggestions: Start by transforming the list of servers into a heap. Then, when assigning each task, use the `heapq.heappop` function to get the server with the minimum load. After adding the task to this server, use the `heapq.heappush` function to add the server back to the heap. Remember to convert the heap back to a list before returning it.
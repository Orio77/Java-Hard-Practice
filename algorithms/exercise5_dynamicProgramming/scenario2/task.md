Task 1:
--------
Implement a dynamic programming solution to optimize project schedules considering resource constraints. Each task has a duration and a set of resources it needs, and you have a limited amount of each resource. Your goal is to schedule the tasks so that the project is completed as soon as possible.

Input: A list of tasks, each with a duration and a set of required resources, and a dictionary of available resources. Each task should not require more resources than are available. 
Example: tasks = [(3, ['A', 'B']), (2, ['A', 'C'])], resources = {'A': 2, 'B': 1, 'C': 1}.

Output: The optimal schedule of tasks, and the total project duration. 
Example: [(2, ['A', 'C']), (3, ['A', 'B'])], 5.

Hint: Start by sorting the tasks by their duration. Then, use a dynamic programming approach to find the optimal schedule. Remember to update the available resources as you schedule each task.

Task 2:
--------
Apply memoization techniques to the above problem to improve the efficiency of task allocation and minimize project completion time.

Input: The same as in task 1.

Output: The same as in task 1, but the solution should be more efficient.

Hint: Implement a memoization table to store the optimal schedule for each subset of tasks and resources. Before computing the optimal schedule for a subset, check if it is already in the memoization table.

Task 3:
--------
Implement a solution to the Knapsack problem for resource allocation. Each resource has a cost and a value, and you have a limited budget. Your goal is to allocate the resources to maximize the total value.

Input: A list of resources, each with a cost and a value, and a budget. 
Example: resources = [(3, 4), (2, 3), (4, 2)], budget = 7.

Output: The optimal allocation of resources, and the total value. 
Example: [(3, 4), (2, 3)], 7.

Hint: Use a dynamic programming approach to solve the Knapsack problem. Start by creating a table with one row for each resource and one column for each possible budget. Then, fill in the table by considering each resource and each possible budget.
Scenario: "Climbing Stairs with Dynamic Programming"

In this scenario, you are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps. Your task is to find out how many distinct ways you can climb to the top.

**Task 1: Understand the problem and identify the states and decisions.**

- Enhanced Instruction: Identify what the states and decisions are in this problem. A state represents a situation that could occur in the solution, and a decision is an action that changes the state. Write down your definitions.
    
- Coach Suggestions: In this problem, a state could be defined by the remaining steps to reach the top. A decision could be whether to climb 1 step or 2 steps at a time.
    

**Task 2: Formulate a recurrence relation for the problem.**

- Enhanced Instruction: Based on your definitions of states and decisions, formulate a recurrence relation for the problem. This is an equation that expresses the solution to the problem in terms of smaller sub-problems.
    
- Coach Suggestions: The number of ways to reach the top from the current step is equal to the sum of the number of ways to reach the top from the next step and the step after next.
    

**Task 3: Implement a dynamic programming solution based on the recurrence relation.**

- Enhanced Instruction: Create a function `climb_stairs(n: int) -> int` that takes the total number of steps and returns the total number of distinct ways you can climb to the top. Use a dynamic programming approach based on the recurrence relation you formulated.
    
- Potential Input: `3`
    
- Desired Output: `3`
    
- Coach Suggestions: Start by creating an array where the i-th element represents the number of ways to reach the top from the i-th step. Initialize the array with 0. Then, fill in the array by iterating over the steps from the top to the bottom, and applying the recurrence relation. Finally, return the value in the first element of the array.
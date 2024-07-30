package algorithms.exercise5_dynamicProgramming.scenario3;

public class Stairs {
    int numberOfStairs;

    public Stairs(int stairs) {
        numberOfStairs = stairs;
    }
    
    // States and Decisions
    /*
     * State: i (current step)
     * 
     * Decision: climb 1 step / climb 2 steps
     * 
     * Recurrence Relation:  f(i) = f(i-1) + f(i-2)
     * 
     * Formulating the recurrence relation: 
     * Let's denote f(i) as the number of distinct ways to reach the ith step. 
     * To reach the ith step, we could either come from the (i-1)th step (by climbing 1 step) 
     * or from the (i-2)th step (by climbing 2 steps). 
     * So, the total number of ways to reach the ith step is 
     * the sum of the number of ways to reach the (i-1)th and (i-2)th steps. 
     * Therefore, the recurrence relation is f(i) = f(i-1) + f(i-2).
     */



    public int climbStairs() {
        if (numberOfStairs <= 1) {
            return 1;
        }
        int[] dp = new int[numberOfStairs + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }

        dp[numberOfStairs] = 1;
        dp[numberOfStairs - 1] = 1;
        for (int i = numberOfStairs - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i+2];
        }
        return dp[0];
    }
}

package algorithms.exercise5_dynamicProgramming.scenario2;

import java.util.ArrayList;
import java.util.List;
// AI Copied
public class Knapsack {
    List<Resource> resources;
    int budget;

    public Knapsack(List<Resource> resources, int budget) {
        this.resources = resources;
        this.budget = budget;
    }

    public void solve() {
        int[][] dp = new int[resources.size()][budget + 1];

        for (int i = 0; i < resources.size(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= budget; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= resources.size(); i++) {
            for (int j = 1; j <= budget; j++) {
                if (resources.get(i - 1).getCost() > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    int valueWhenExcluded = dp[i - 1][j];
                    int valueWhenIncluded = resources.get(i - 1).getValue() + dp[i - 1][j - resources.get(i - 1).getCost()];
                    dp[i][j] = Math.max(valueWhenExcluded, valueWhenIncluded);
                }
            }
        }

        int maxProfit = dp[resources.size()][budget];
        System.out.println("Max profit is: " + maxProfit);
        int j = budget;
        List<Resource> selectedResources = new ArrayList<>();
        for (int i = resources.size(); i > 0 && maxProfit > 0; i--) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedResources.add(resources.get(i - 1));
                j = j - resources.get(j - 1).getCost();
                maxProfit = maxProfit - resources.get(i - 1).getValue();
            }
        }

        System.out.println("Selected Items: ");
            for (Resource resource : selectedResources) {
                System.out.println("Value: " + resource.getValue() + ", " + resource.getCost());
            }
    }
}

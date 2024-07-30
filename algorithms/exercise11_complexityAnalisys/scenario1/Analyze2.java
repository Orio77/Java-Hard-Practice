package algorithms.exercise11_complexityAnalisys.scenario1;

class Main {
    static int knapSack(int totalWeight, int weights[], int values[], int itemCount) {
        int itemIndex, weightIndex;
        int maxValues[][] = new int[itemCount + 1][totalWeight + 1];

        for (itemIndex = 0; itemIndex <= itemCount; itemIndex++) {
            for (weightIndex = 0; weightIndex <= totalWeight; weightIndex++) {
                if (itemIndex == 0 || weightIndex == 0)
                    maxValues[itemIndex][weightIndex] = 0;
                else if (weights[itemIndex - 1] <= weightIndex)
                    maxValues[itemIndex][weightIndex] = Math.max(values[itemIndex - 1] + maxValues[itemIndex - 1][weightIndex - weights[itemIndex - 1]], maxValues[itemIndex - 1][weightIndex]);
                else
                    maxValues[itemIndex][weightIndex] = maxValues[itemIndex - 1][weightIndex];
            }
        }

        return maxValues[itemCount][totalWeight];
    }

    public static void main(String args[]) {
        int values[] = new int[]{60, 100, 120};
        int weights[] = new int[]{10, 20, 30};
        int totalWeight = 50;
        int itemCount = values.length;
        System.out.println(knapSack(totalWeight, weights, values, itemCount));
    }
}


// My answers:
// Time complexity: O (itemCount * itemCount)
// Space complexity: O (itermCount)

// Correct answers:
// Time complexity: O (itemCount * totalWeight)
// Space complexity: O (itermCount * totalWeight)
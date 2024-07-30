package generics.exercise16_documentation.scenario3;

import java.util.List;

public class Statistics<T extends Number> {
    
    /**
     * Calculates mean of all numbers
     * @param nums takes a list of numbers as a parameter
     * @return returns the mean of all numbers
     */
    public double calculateMean(List<T> nums) {
        double sum = 0.0;
        for(T num : nums) {
            sum += num.doubleValue();
        }
        return sum / nums.size();
    }

    /**
     * calculates standard deviation
     * @param nums takes a generic list of numbers as a paremeter
     * @return return the standard deviation
     */
    public double calculateStandardDeviation(List<T> nums) {
        double mean = calculateMean(nums);
        double sum = 0.0;
        for(T num : nums) {
            sum += Math.pow(num.doubleValue() - mean, 2);
        }
        return Math.sqrt(sum / nums.size());
    }

}
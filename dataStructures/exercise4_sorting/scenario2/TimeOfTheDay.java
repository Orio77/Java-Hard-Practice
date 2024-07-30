package dataStructures.exercise4_sorting.scenario2;


import java.util.Random;

public enum TimeOfTheDay {
    MORNING, NOON, AFTERNOON, EVENING; 

    public static TimeOfTheDay returnRandom() {
        Random random = new Random();

        TimeOfTheDay[] dayTime = {MORNING, NOON, AFTERNOON, EVENING};

        return dayTime[random.nextInt(4)];
    }
}

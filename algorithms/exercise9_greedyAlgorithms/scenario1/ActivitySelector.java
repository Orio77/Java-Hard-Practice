package algorithms.exercise9_greedyAlgorithms.scenario1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ActivitySelector {
    private Activity[] activities;
    private LinkedList<Activity> selectedActivities;

    public ActivitySelector(Activity[] activities) {
        this.activities = activities;
    }

    public void sortActivities() {
        Arrays.stream(activities).sorted(Comparator.comparing(a -> a.getEndTime()));
    }

    private Activity getEarliestActivity() {
        ArrayList<Activity> sorted = new ArrayList<>();
        sorted.sort(Comparator.comparing(a -> a.getStartTime()));
        return sorted.get(0);
    }

    public void selectActivities() {
        selectedActivities = new LinkedList<>();
        selectedActivities.add(getEarliestActivity());
        for (Activity activity : activities) {
            if (activity.getStartTime() > selectedActivities.getLast().getEndTime());
        }
    }
}

/*3. **Addressing Activity Selection Problem Using Greedy Approaches:**
    
    - The activities are sorted based on their end times. This could be done using a sorting algorithm.
    - The activities are then selected in the order they appear in the sorted list, as long as they are compatible with the already selected activities. An activity is compatible if its start time is later than the end time of the last selected activity. The goal is to select a maximum-size set of mutually compatible activities. */
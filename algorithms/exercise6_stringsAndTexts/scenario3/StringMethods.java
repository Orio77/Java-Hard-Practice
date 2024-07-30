package algorithms.exercise6_stringsAndTexts.scenario3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StringMethods {
    // AI helped with indeces of inner loop
    public static List<String> getSubstrings(String str) {
        int startPosition = 0;
        int endPosition = str.length();
        LinkedList<String> substrings = new LinkedList<>();

        for (int i = startPosition; i < endPosition; i++) {
            for (int j = i + 1; j <= startPosition; j++) {
                substrings.add(str.substring(i, j));
            }
        }

        return substrings;
    }

    public static HashMap<String, Integer> calculateFrequency(List<String> strings) {
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String string : strings) {
            if (!frequency.containsKey(string)) {
                frequency.put(string, 1);
            }
            else {
                frequency.replace(string, frequency.get(string) + 1);
            }
        }
        return frequency;
    }

    public static String getMostFrequentString(HashMap<String, Integer> strDict) {
        String mostFrequent = strDict.keySet().iterator().next();
        for (String str : strDict.keySet()) {
            if (strDict.get(str) > strDict.get(mostFrequent)) {
                mostFrequent = str;
            }
        }
        return mostFrequent;
    }
}

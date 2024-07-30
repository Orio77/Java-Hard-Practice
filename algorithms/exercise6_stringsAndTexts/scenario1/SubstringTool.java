package algorithms.exercise6_stringsAndTexts.scenario1;

import java.util.ArrayList;

public class SubstringTool {

    public static ArrayList<String> generateSubstrings(String string) {
        ArrayList<String> subStrings = new ArrayList<>();
        generateSubstringsHelper(string, 0, 0, subStrings);
        return subStrings;
    }

    private static void generateSubstringsHelper(String string, int start, int end, ArrayList<String> subStrings) {
        if (end == string.length())
            return;
        else if (start > end)
            generateSubstringsHelper(string, 0, end + 1, subStrings);
        else {
            subStrings.add(string.substring(start, end + 1));
            generateSubstringsHelper(string, start + 1, end, subStrings);
        }
    }

    public void showSubstrings(String string) {
        generateSubstrings(string);
    }
}

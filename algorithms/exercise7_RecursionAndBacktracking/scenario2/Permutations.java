package algorithms.exercise7_RecursionAndBacktracking.scenario2;

import java.util.ArrayList;
import java.util.List;
// AI Copied
public class Permutations {
    private String str;

    public Permutations(String string) {
        str = string;
    }

    public List<String> getPermutations() {
        ArrayList<String> permutationList = new ArrayList<>();

        if (str == null || str.length() == 0)
            return permutationList;
        
        generatePermutation(str, "", permutationList);
        return permutationList;
    }

    private void generatePermutation(String str, String prefix, ArrayList<String> permutationList) {
        if (str.length() == 0)
            permutationList.add(prefix);
        else {
            for (int i = 0; i < str.length(); i++) {
                generatePermutation(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i), permutationList);
            }
        }
    }
}

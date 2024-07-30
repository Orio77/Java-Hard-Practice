package algorithms.exercise7_RecursionAndBacktracking.scenario1;

import java.util.ArrayList;
import java.util.List;
// AI copied
public class Combinations {
    List<Integer> pieces;

    public List<List<Integer>> generateCombinations() {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinationsHelper(result, new ArrayList<>(), pieces, 0);
        return result;
    }

    public void generateCombinationsHelper(List<List<Integer>> result, List<Integer> combination, List<Integer> pieces, int start) {
        result.add(new ArrayList<>(combination));
        for (int i = start; i < pieces.size(); i++) {
            combination.add(pieces.get(i));
            generateCombinationsHelper(result, combination, pieces, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}

// I don't understand
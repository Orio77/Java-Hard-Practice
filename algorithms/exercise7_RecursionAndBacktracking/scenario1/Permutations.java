package algorithms.exercise7_RecursionAndBacktracking.scenario1;

import java.util.Collections;
import java.util.List;
// AI copied
public class Permutations {
    private List<Integer> pieces;

    public Permutations(List<Integer> pieces) {
        this.pieces = pieces;
    }

    public void generatePermutations() {
        generatePermutationsHelper(0);
    }

    private void generatePermutationsHelper(int start) {
        if (start == pieces.size() - 1) {
            System.out.println(pieces);
            return;
        }

        for (int i = 0; i < pieces.size(); i++) {
            Collections.swap(pieces, start, i);
            generatePermutationsHelper(start + 1);
            Collections.swap(pieces, start, i);
        }
    }
}

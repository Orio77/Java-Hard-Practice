package algorithms.exercise6_stringsAndTexts.scenario1;
// AI copied
public class KMPAlgorithm {
    private String pattern;
    private int[] failureArray;


    public KMPAlgorithm(String pattern) {
        this.pattern = pattern;
        this.failureArray = new int[pattern.length()];
        computeFailureArray();
    }

    public void computeFailureArray() {
        int patternLength = pattern.length();
        int length = 0;
        int i = 1;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                failureArray[i] = length;
                i++;
            }
            else {
                if (length != 0)
                    length = failureArray[length - 1];
                else{
                    failureArray[i] = length;
                    i++;
                }
            }
        }
    }

    public void KMPsearch(String text) {
        int patternLength = pattern.length();
        int textLength = text.length();

        int i = 0;
        int j = 0;

        while (i < textLength) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == patternLength) {
                System.out.println("Found pattern at index: " + (i - j));
                j = failureArray[j - 1];
            }
            else if (i < textLength && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = failureArray[j - 1];
                else 
                    i++;
            }
        }
    }
}

// I don't understand
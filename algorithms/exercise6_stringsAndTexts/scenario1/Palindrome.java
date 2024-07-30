package algorithms.exercise6_stringsAndTexts.scenario1;

public class Palindrome {
    private String string;

    public boolean isPalindrome() {
        for (int i = 0; i < (string.length() / 2); i++) {
            char firstLetter = string.charAt(i);
            char lastLetter = string.charAt(string.length() - i - 1);
            if (firstLetter != lastLetter) {
                return false;
            }
        }
        return true;
    }
}

package algorithms.exercise6_stringsAndTexts.scenario1;

import java.util.Arrays;

public class Anagram {
    private String string1;
    private String string2;

    public Anagram(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public boolean isAnagram() {
        if (string1.length() != string2.length())
            return false;

        char[] chars1 = new char[string1.length()];
        char[] chars2 = new char[string2.length()];

        for (int i = 0; i < string1.length(); i++) {
            chars1[i] = string1.charAt(i);
        }
        for (int i = 0; i < string2.length(); i++) {
            chars2[i] = string2.charAt(i);
        }

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i])
                return false;
        }

        return true;
    }
}

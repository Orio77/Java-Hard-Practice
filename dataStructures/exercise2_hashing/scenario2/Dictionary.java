package dataStructures.exercise2_hashing.scenario2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Dictionary {
    private HashMap<Integer, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    // Adds a word to dictionary
    public void addToDictionary(Word word) {
        if (isInDictionary(word) < 0)
            dictionary.put(word.hashCode(), word.getContent());
        else
            System.out.println("There is such word in dictionary already");
    }

    // Prints the Dictionary as key-value pairs
    public void showDictionary() {
        System.out.println(dictionary.toString());
    }

    // Checks if dictionary contains the word
    public int isInDictionary(Word word) {
        if (dictionary.containsKey(word.getContent().hashCode())) {
            return 1;
        }
        return -1;
    }

    // How to implement a Trie spell-checker?
    public void spellChecker(Word word) {
        if (isInDictionary(word) < 0) {
            String prefix = word.getContent().substring(0, 1);

            Iterator<String> valueIterator = dictionary.values().iterator();
            ArrayList<String> matched = new ArrayList<>();

            while (valueIterator.hasNext()) {
                String nextWord = valueIterator.next();
                if (nextWord.substring(0, 1).matches(prefix)) {
                    matched.add(nextWord);
                }
            }

            System.out.println("No such word in dictionary");
            System.out.println("Perhaps you meant one of these?");
            System.out.println(matched);
        }
    }
}

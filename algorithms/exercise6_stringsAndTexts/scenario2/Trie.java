package algorithms.exercise6_stringsAndTexts.scenario2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// AI Copied
class TrieNode {
    private final TrieNode[] links;
    private boolean isEnd;
    private String word;

    public TrieNode() {
        links = new TrieNode[26]; // letters in the alphabet
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        this.isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
    public TrieNode[] getLinks() {
        return links;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getWord() {
        return word;
    }
}

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currLetter = word.charAt(i);
            if (node.containsKey(currLetter)) {
                node = node.get(currLetter);
            }
            else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public List<String> startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        List<String> result = new ArrayList<>();
        collect(node, result);
        return result;
    }

    private void collect(TrieNode node, List<String> result) {
        if (node == null)
            return;

        if (node.isEnd()) 
            result.add(node.getWord());

        for (char c = 'a'; c <= 'z'; c++) {
            if (node.containsKey(c)) 
                collect(node.get(c), result);
        }
    }

    public List<String> processQuery(String query) {
        query = query.toLowerCase(); // convert to lowercase
        query = query.replaceAll("[^a-z]", ""); // remove punctuation
        return Arrays.asList(query.split("\\s+")); // split into words
    }
}

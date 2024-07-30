package dataStructures.exercise2_hashing.scenario2;

public class Main {
    
    public static void main(String[] args) {
        
        Dictionary englishDictionary = new Dictionary();
        Word word1 = new Word("elephant");
        Word word2 = new Word("apple");

        englishDictionary.addToDictionary(word1);
        englishDictionary.addToDictionary(word2);
        englishDictionary.showDictionary();


    }
}
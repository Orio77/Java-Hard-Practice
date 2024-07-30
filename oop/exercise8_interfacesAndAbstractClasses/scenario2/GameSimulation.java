package oop.exercise8_interfacesAndAbstractClasses.scenario2;

import java.util.ArrayList;

public class GameSimulation {
    private CharacterFactory factory;
    private ArrayList<GameCharacter> characters;

    public GameSimulation() {
        characters = new ArrayList<>();
        factory = new CharacterFactory();
    }

    public void createCharacters(int number) {
        for (int i = 0; i < number; i++) {
            characters.add(factory.createCharacter("Wizard"));
            characters.add(factory.createCharacter("Rogue"));
        }
    }

    public void run() {
        createCharacters(10);

        for (GameCharacter character : characters) {
            character.move();
            character.attack();
            character.castSpell();
            character.defend();
            character.heal();
        }
    }

    public static void main(String[] args) {
        GameSimulation game = new GameSimulation();
        game.run();
    }
}

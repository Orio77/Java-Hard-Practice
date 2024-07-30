package oop.exercise8_interfacesAndAbstractClasses.scenario2;

public class CharacterFactory {
    

    public GameCharacter createCharacter(String characterType) {

        switch (characterType) {
            case "Wizard":
                return new Wizard(100, 5, 20);
            case "Rogue":
                return new Rogue(120, 20, 2);
            default:
                break;
        }
        return null;
    }
}

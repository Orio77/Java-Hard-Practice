package oop.exercise8_interfacesAndAbstractClasses.scenario2;

public class Wizard extends GameCharacter{

    public Wizard(int hp, int ad, int ap) {
        super(hp, ad, ap);
    }

    @Override
    public void attack() {
        castSpell();
    }

    @Override
    public void defend() {
        castSpell();
    }

    @Override
    public void move() {
        System.out.println("Wizard is moving");
    }

    @Override
    public void castSpell() {
        System.out.println("Wizard is casting a spell");
    }

    @Override
    public void stealth() {
        System.out.println("No such ability");
    }

    @Override
    public void heal() {
        System.out.println("No such ability");
    }
    
}

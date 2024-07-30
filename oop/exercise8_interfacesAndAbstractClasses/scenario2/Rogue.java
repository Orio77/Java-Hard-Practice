package oop.exercise8_interfacesAndAbstractClasses.scenario2;

public class Rogue extends GameCharacter{

    public Rogue(int hp, int ad, int ap) {
        super(hp, ad, ap);
    }

    @Override
    public void attack() {
        System.out.println("Rogue attacking");
    }

    @Override
    public void defend() {
        System.out.println("Rogue defending");
    }

    @Override
    public void move() {
        System.out.println("Rogue moving");
    }

    @Override
    public void castSpell() {
        // TODO Auto-generated method stub
        System.out.println("No such ability");
    }

    @Override
    public void stealth() {
        System.out.println("Rogue becoming invisible");
    }

    @Override
    public void heal() {
        System.out.println("No such ability");
    }
    
}

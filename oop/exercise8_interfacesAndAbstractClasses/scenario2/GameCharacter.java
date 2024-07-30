package oop.exercise8_interfacesAndAbstractClasses.scenario2;

public abstract class GameCharacter implements ICharacterBehaviour{
    private int hp;
    private int ad;
    private int ap;

    public GameCharacter(int hp, int ad, int ap) {
        this.hp = hp;
        this.ad = ad;
        this.ap = ap;
    }

    public void move() {
        System.out.println("Character moving");
    }

    public void attack() {
        System.out.println("Character attacking");
    }

    public void defend() {
        System.out.println("Character defending");
    }

    public int getAd() {
        return ad;
    }
    public int getAp() {
        return ap;
    }
    public int getHp() {
        return hp;
    }
}

package oop.exercise11_staticAndFinal.scenario2;

public class LibraryCard {
    private final int cardNumber;
    private int issuedTo;
    private static int totalCards;

    public LibraryCard() {
        totalCards++;
        cardNumber = Integer.toString(totalCards).hashCode();
        issuedTo = 10;
    }

    public int getCardNumber() {
        return cardNumber;
    }
    public int getIssuedTo() {
        return issuedTo;
    }
    public static int getTotalCards() {
        return totalCards;
    }
}

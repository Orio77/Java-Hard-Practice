package oop.exercise15_designPrinciples.scenario2;

public class ProductNotAvailableException extends Exception{
    
    public ProductNotAvailableException(String message) {
        super(message);
    }
}

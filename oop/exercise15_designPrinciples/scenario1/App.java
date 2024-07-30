package oop.exercise15_designPrinciples.scenario1;

import java.util.ArrayList;
import java.util.List;

public class App implements Subject{
    List<Observer> observers;

    public App() {
        observers = new ArrayList<>();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.notify();
        }
    }
}

package generics.exercise13.scenario1;

import java.util.ArrayList;
import java.util.List;

public class StateChangeObservable<T> implements Observable<StateChangeEvent<T>> {
    private List<Observer<StateChangeEvent<T>>> observers;

    public StateChangeObservable() {
        observers = new ArrayList<>();
    }

    @Override
    public boolean registerObserver(Observer<StateChangeEvent<T>> obeserver) {
        return observers.add(obeserver);
    }

    @Override
    public boolean unregisterObserver(Observer<StateChangeEvent<T>> observer) {
        if (observers.contains(observer))
            return observers.remove(observer);

        return false;
    }

    @Override
    public void notifyObservers(StateChangeEvent<T> type) {
        for (Observer<StateChangeEvent<T>> observer : observers) {
            observer.notifyAll(type);
        }
    }


    
}

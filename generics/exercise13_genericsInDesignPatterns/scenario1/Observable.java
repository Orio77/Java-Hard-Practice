package generics.exercise13.scenario1;

public interface Observable<T> {
    
    boolean registerObserver(Observer<T> obeserver);
    boolean unregisterObserver(Observer<T> observer);
    void notifyObservers(T type);
}

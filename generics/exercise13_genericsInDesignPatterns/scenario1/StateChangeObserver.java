package generics.exercise13.scenario1;

public class StateChangeObserver<T> implements Observer<StateChangeEvent<T>> {

    @Override
    public void notifyAll(StateChangeEvent<T> event) {
        System.out.println("Previous state was: " + event.getPreviousState());
        System.out.println("Current state is: " + event.getCurrentState());
    }

}

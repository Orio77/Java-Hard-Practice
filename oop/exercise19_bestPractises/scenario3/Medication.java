package oop.exercise19_bestPractises.scenario3;

public interface Medication extends TreatmentProcedure {
    
    @Override
    public default void performProcedure() {
        System.out.println("Giving medication");
    }
}

package oop.exercise19_bestPractises.scenario3;

public interface TreatmentProcedure {
    
    default void performProcedure() {
        System.out.println("Performing the procedure");
    }
}

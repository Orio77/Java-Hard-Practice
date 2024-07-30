package oop.exercise19_bestPractises.scenario3;

public interface Surgery extends TreatmentProcedure{
    
    @Override
    public default void performProcedure() {
        System.out.println("Performing surgery");
    }
}

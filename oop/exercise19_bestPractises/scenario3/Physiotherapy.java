package oop.exercise19_bestPractises.scenario3;

public interface Physiotherapy extends TreatmentProcedure{
    
    @Override
    public default void performProcedure() {
        System.out.println("Performing physiotherapy");
    }
}

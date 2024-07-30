package oop.exercise15_designPrinciples.scenario1;

public class FeedbackSystem implements Observer{
    
    public void collectFeedback() {
        System.out.println("Collecting feedback");
    }

    public void runUsabilityTest() {
        System.out.println("Testing the application");
    }

    @Override
    public void update() {
        collectFeedback();
    }
}

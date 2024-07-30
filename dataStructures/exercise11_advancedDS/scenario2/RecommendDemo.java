package dataStructures.exercise11_advancedDS.scenario2;

public class RecommendDemo {
    public static void main(String[] args) {

        RecommendationSystem system = new RecommendationSystem();
        User me = new User("password");

        me.simulateContentConsumption(4000);
        system.simulateContentBase(100000);

        system.showRecommendations(me);
    }
}

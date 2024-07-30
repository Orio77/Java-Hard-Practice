package generics.exericse10.scenario3;

import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine<T extends User> {
    
    /**
     * A method that recommends the products that user has bought more than twice
     * 
     * @param user
     * @return list of recommendation products
     */
    public List<String> generateRecommendations(T user) {
        List<String> recommendations = new ArrayList<>();

        for (String product : recommendations) {
            if (recommendations.stream().filter(p -> !p.equals(product)).count() > 2)
                recommendations.add(product);
        }

        return recommendations;
    }

    public void adaptAlgorithm(T user) {
        if (user.isPremium()) {
            System.out.println("The user is premium. Adapting the algorithm");
        }
        else {
            System.out.println("The user is poor. Adapting the algorithm");
        }
    }

    public void testRecommendation(T user) {
        System.out.println("Testing the recommendation system");
    }
}

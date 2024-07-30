package dataStructures.exercise5_dynamicStructures.scenario3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class RecommendationSystem {
    private double[][] recommendationGraph;
    private LinkedList<Product> products;
    private HashMap<Integer, LinkedList<Product>> userData;
    private ArrayList<User> userBase;

    public RecommendationSystem() {
        products = new LinkedList<>();
        recommendationGraph = new double[products.size() * 2][products.size() * 2];
        userData = new HashMap<>();
        userBase = new ArrayList<>();
        initializeData();
        initializeRecommendationGraph();
    }

    // Adds product to the list and checks if the graph is full, to resize it
    public void addProduct(Product product) {
        products.add(product);

        if (products.size() >= recommendationGraph.length) {
            recommendationGraph = new double[products.size() * 2][products.size() * 2];
        }
    }

    public void addProducts(ArrayList<Product> delivery) {
        products.addAll(delivery);

        if (products.size() >= recommendationGraph.length) {
            recommendationGraph = new double[products.size() * 2][products.size() * 2];
        }
    }

    // Initialize a weighted, undirected graph with an adjacency matrix
    public void initializeRecommendationGraph() {

        for (int i = 0; i < recommendationGraph.length; i++) {
            for (int j = 0; j < recommendationGraph.length; j++) {
                double currentRelevance = Product.calculateProductsRelevance(products.get(i), products.get(j));
                recommendationGraph[i][j] = currentRelevance;
                recommendationGraph[j][i] = currentRelevance;
                if (i == j)
                    recommendationGraph[i][j] = 10.0;
            }
        }
    }

    public void registerUser(User user) {
        userBase.add(user);
    }

    public void registerUsers(ArrayList<User> userList) {
        userBase.addAll(userList);
    }

    public void initializeData() {
        for (User user : userBase) {
            userData.put(user.getUserID(), user.getListOfInterest());
        }
    }

    // We get the list of products user is interested in
    // We use the graph to find the products that are of higher relevance than 8.00
    // We return the list of Products with recommendations
    public LinkedList<Product> getRecommendationList(int userID) {
        LinkedList<Product> productsOfInterest = userData.get(userID);
        LinkedList<Product> fullRecommendationList = new LinkedList<>();

        if (productsOfInterest == null) {
            System.out.println("User ID: " + userID + " has no products of interest.");
            return new LinkedList<>();
        }

        for (Product product : productsOfInterest) {
            Iterator<Product> iterator = products.iterator();
            int index = -1;

            while (iterator.hasNext()) {
                index++;
                if (iterator.next().equals(product)){
                    break;
                }
            }
            if (index != -1 && index < recommendationGraph.length){
                System.out.println("Product: " + product + " is at index: " + index + " in the products list.");
                for (int i = 0; i < recommendationGraph.length; i++) {
                    if (recommendationGraph[index][i] > 8.00)
                        fullRecommendationList.add(products.get(i));
                }
            }
            else {
                System.out.println("Product: " + product + " is not found in the products list.");
            }
        }
        return fullRecommendationList;
    }

    public void runSimulation(int productNumber, int userNumber) {
        Random random = new Random();
        addProducts(Product.generateTestProducts(productNumber));
        registerUsers(User.generateTestUsers(userNumber));
        initializeData();

        for (int i = 0; i < recommendationGraph.length; i++) {
            int drawProduct = random.nextInt(products.size());
            int drawUser = random.nextInt(userBase.size());
            userBase.get(drawUser).viewProduct(products.get(drawProduct));

            System.out.println(getRecommendationList(drawUser));
        }
    }
}

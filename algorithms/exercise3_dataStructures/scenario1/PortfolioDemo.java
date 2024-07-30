package algorithms.exercise3_dataStructures.scenario1;

public class PortfolioDemo {
    public static void main(String[] args) {

        Portfolio portfolio = new Portfolio();

        portfolio.generateAssetsForTests(11, 10);

        portfolio.showTree();
    }
}

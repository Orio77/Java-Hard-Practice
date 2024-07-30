package algorithms.exercise1_sorting.scenario1;

public class EcommerceDemo {
    public static void main(String[] args) {
        EcommerceSystem ecom = new EcommerceSystem();

        ecom.generateSampleProductsForTests();
        ecom.bubbleSortPrice();
        ecom.printProductsSample();
    }
}

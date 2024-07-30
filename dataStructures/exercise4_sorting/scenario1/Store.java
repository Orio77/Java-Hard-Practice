package dataStructures.exercise4_sorting.scenario1;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<Storage> storages;

    public Store() {
        storages = new ArrayList<>();
    }

    public void addStorage(Storage storage) {
        storages.add(storage);
    }

    public Product searchProduct(String category, String name) throws NullPointerException{
        Storage storageToSearch = findStorage(category);
        ArrayList<Product> products = storageToSearch.getProducts();

        for (Product product : products) {
            if (product.equals(name)) {
                return product;
            }
        }

        return null;
    }

    public Storage findStorage(String category) throws NullPointerException{

        for (Storage storage : storages) {
            if (storage.getCategory().equals(category)) {
                return storage;
            }
        }
        return null;
    }

    public void listProducts() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Categories: " + Storage.getCategories());
            System.out.print("Enter category: ");
            String category = sc.nextLine().toLowerCase();
            boolean wasFound = false;
            String foundCategory = null;

            for (String string : Storage.getCategories()) {
                if (string.equals(category)) {
                    wasFound = true;
                    foundCategory = string;
                    break;
                }
            }

            if (wasFound == false) {
                System.out.println("No such category");
                return;
            }

            for (Storage storage : storages) {
                if (storage.getCategory().equals(foundCategory)) {
                    System.out.println(storage.getProducts());
                }
            }
        }
    }
}

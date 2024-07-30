package files.exercise4_exceptionHandling.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Product {
    private int id;
    private String name;
    private int quantity;

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
    public Product() {
        this(0, "Error", 0);
    }
    public String getData() {
        return Integer.toString(this.id) + ";" + this.name + ";" + Integer.toString(this.quantity);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
}

public class InventoryManager {

    // Task 1
    public List<Product> readInventoryFile(String filePath) {
        
        try {
            List<Product> products = new ArrayList<>();
            Files.readAllLines(Paths.get(filePath)).stream().forEach(line -> {
                String[] data = line.split(";");
                products.add(new Product(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2])));
            });
            return products;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean updateInventoryFile(List<Product> products, String filePath) {
        try {
            for (Product product : products) {
                Files.write(Paths.get(filePath), product.getData().getBytes(), StandardOpenOption.APPEND);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Task 2
    public String checkFilePermission(String filePath) {
        File file = Paths.get(filePath).toFile();

        return "canWrite : " + file.canWrite() + 
        "\ncanRead: " + file.canRead() + 
        "\ncanExecute: " + file.canExecute();

    }

    public boolean changeFilePermission(String filePath, String permission) {
        File file = Paths.get(filePath).toFile();

        switch (permission) {
            case "canRead":
                file.setReadable(true);
                return true;

            case "canWrite":
                file.setWritable(true);
                return true;

            case "canExecute":
                file.setExecutable(true);
                return true;
        
            default:
                return false;
        }
    }

    // Task 3
    public Map<Integer, Product> readInventoryFileToMap(String filePath) {
        Map<Integer, Product> map = new HashMap<>();
        try {
            Files.readAllLines(Paths.get(filePath)).stream().forEach(line -> {
                String[] data = line.split(";");
                map.put(Integer.parseInt(data[0]), new Product(Integer.parseInt(data[1]), data[2], Integer.parseInt(data[2])));
            });
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public boolean updateInventoryFileFromMap(Map<Integer, Product> products, String filePath) {
        try {
            for (Map.Entry<Integer, Product> entry : products.entrySet()) {
                Files.write(Paths.get((filePath)), (Integer.toString(entry.getKey()) + ";" + entry.getValue().getData()).getBytes(), StandardOpenOption.APPEND);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Task 4
    public List<Product> readLargeInventoryFile(String filePath) {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))){
            List<Product> products = new ArrayList<>();
            reader.lines().forEach(line -> {
                String[] data = line.split(";");
                products.add(new Product(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2])));
            });
            return products;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }


            
    }

    public boolean updateLargeInventoryFile(List<Product> products, String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            for (Product product : products) {
                writer.write(product.getData());
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Product searchProductInLargeInventoryFile(int id, String filePath) {
        return readInventoryFileToMap(filePath).get(id);
    }
}

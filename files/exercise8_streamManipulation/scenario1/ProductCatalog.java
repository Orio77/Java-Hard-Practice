package files.exercise8_streamManipulation.scenario1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductCatalog {
    private String absolutePath;
    // Task 1
    public void addProduct(String productId, String productDetails) {
        String fileName = productId + ".txt";
        Path absolutePath = Paths.get(this.absolutePath, fileName);

        try {
            if (!Files.exists(absolutePath)) {
                Files.createFile(absolutePath);
            }
    
            Files.writeString(absolutePath, productDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProduct(String productId) {
        File target = null;
        Optional<File> product = Arrays.stream(Paths.get(absolutePath).toFile().listFiles()).filter(p -> {
            if (p.getName().contains(productId)) {
                return true;
            }
            return false;
        }).findAny();

        if (!product.isPresent()) {
            return "";
        }
        else {
            target = product.get();
            try (BufferedReader reader = new BufferedReader(new FileReader(target));) {
                return reader.lines().collect(Collectors.joining());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    // Task 2
    public void makeProductPrivate(String productId) {
        File target = null;
        Optional<File> product = Arrays.stream(Paths.get(absolutePath).toFile().listFiles()).filter(p -> {
            if (p.getName().contains(productId)) {
                return true;
            }
            return false;
        }).findAny();

        if (!product.isPresent()) {
            return;
        }
        else {
            target = product.get();
            target.setReadable(false);
            target.setWritable(false);
            target.setExecutable(false);
            target.setExecutable(true, true);
            target.setReadable(true, true);
            target.setWritable(true, true);
        }
    }

    public void makeProductPublic(String productId) {
        File target = null;
        Optional<File> product = Arrays.stream(Paths.get(absolutePath).toFile().listFiles()).filter(p -> {
            if (p.getName().contains(productId)) {
                return true;
            }
            return false;
        }).findAny();

        if (!product.isPresent()) {
            return;
        }
        else {
            target = product.get();
            target.setReadable(true);
            target.setWritable(true);
            target.setExecutable(true);
        }
    }

    // Task 3
    public void addProductBuffered(String productId, String productDetails) {
        String fileName = productId + ".txt";
        Path absolutePath = Paths.get(this.absolutePath, fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(this.absolutePath)))) {
            if (!Files.exists(absolutePath)) {
                Files.createFile(absolutePath);
            }
            writer.write(productDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProductBuffered(String productId) {
        File target = null;
        Optional<File> product = Arrays.stream(Paths.get(absolutePath).toFile().listFiles()).filter(p -> {
            if (p.getName().contains(productId)) {
                return true;
            }
            return false;
        }).findAny();

        if (!product.isPresent()) {
            return "";
        }
        else {
            target = product.get();
            try (BufferedReader reader = new BufferedReader(new FileReader(target));) {
                return reader.lines().collect(Collectors.joining());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    // Task 4
    public List<String> getProducts() {
        return Arrays.stream(Paths.get(absolutePath).toFile().listFiles()).map((File file) -> file.getName()).map(name -> name.replace(".txt", "")).toList();
    }

    public void deleteProduct(String productId) {
        
        try {
            Files.delete(Paths.get(absolutePath + "\\" +productId + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(String productId, String newDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(absolutePath + "\\" +productId + ".txt")))) {
            writer.write(newDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package files.exercise15_documentation.scenario2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TransactionRecordSystem {

    // Task 1
    public void recordTransaction(String transactionData, String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)){
            writer.write(transactionData.hashCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String retrieveTransaction(String transactionId, String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String data = reader.lines().filter(line -> line.contains(transactionId)).findFirst().get();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return new String();
        }
    }

    // Task 2
    public void setFilePermissions(String filePath, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<PosixFilePermission> checkFilePermissions(String filePath) {
        try {
            return Files.getPosixFilePermissions(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    // Task 3
    public void recordTransactionsBulk(List<String> transactions, String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)){
            writer.write(transactions.stream().collect(Collectors.joining()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> retrieveTransactionsBulk(String filePath) {
        try {
            List<String> data = new ArrayList<>();
            File[] files = Paths.get(filePath).toFile().listFiles();
            BufferedReader reader = null;
            for (File file : files) {
                reader = Files.newBufferedReader(file.toPath());
                data.add(reader.lines().collect(Collectors.joining("\n")));
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Task 4
    public void recordTransactionSafe(String transactionData, String filePath) {
        if (transactionData == null || filePath == null || transactionData.isEmpty() || filePath.isEmpty()) {
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)){
            writer.write(transactionData.hashCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String retrieveTransactionSafe(String transactionId, String filePath) {
        if (transactionId == null || filePath == null || transactionId.isEmpty() || filePath.isEmpty()) {
            return new String();
        }

        return retrieveTransaction(transactionId, filePath);
    }

    public void setFilePermissionsSafe(String filePath, Set<PosixFilePermission> permissions) {
        if (filePath == null || permissions == null || permissions.isEmpty() || filePath.isEmpty()) {
            return;
        }

        setFilePermissions(filePath, permissions);
    }
}

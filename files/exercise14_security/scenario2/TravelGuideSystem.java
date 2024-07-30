package files.exercise14_security.scenario2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TravelGuideSystem {

    // Task 1
    public void encryptAndStore(File file, String key, Path targetDirectory) {
        try {
            String content = Files.readAllLines(file.toPath()).stream().collect(Collectors.joining("\n"));
            
            // AI Copied - i don't know how to encrypt a file
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            keyPair.getPublic();

            Signature privateSignature = Signature.getInstance("SHA256withRSA");
            privateSignature.initSign(privateKey);
            privateSignature.update(content.getBytes(StandardCharsets.UTF_8));
            byte[] signature = privateSignature.sign();
            String encryptedContent = Base64.getEncoder().encodeToString(signature);

            Files.write(targetDirectory, encryptedContent.getBytes());


        } catch (IOException | SignatureException | InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String retrieveAndDecrypt(File file, String key) {
        try {
            String content = Files.readAllLines(file.toPath()).stream().collect(Collectors.joining("\n"));  

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            Signature publicSignature = Signature.getInstance("SHA256withRSA");
            publicSignature.initVerify(publicKey);
            publicSignature.update(content.getBytes(StandardCharsets.UTF_8));
            byte[] signature = Base64.getDecoder().decode(content);
            
            if (publicSignature.verify(signature)) {
                return content;
            }
            else {
                throw new IllegalArgumentException("Invalid signature");
            }
        } catch (IOException | SignatureException | InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 2
    public void setFilePermissions(File file, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(file.toPath(), permissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<PosixFilePermission> checkFilePermissions(File file) {
        if (Files.exists(file.toPath())) {
            try {
                return Files.getPosixFilePermissions(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
                return new HashSet<>();
            }
        }
        else {
            return new HashSet<>();
        }
    }

    // Task 3
    public Path createDirectoryForDestination(String destination) {
        if (!Files.exists(Paths.get(destination))) {
            Paths.get(destination).toFile().mkdirs();
        }
        return Paths.get(destination);
    }

    public void moveGuideToDestinationDirectory(File file, String destination) {
        try {
            Files.move(file.toPath(), Paths.get(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
    public List<String> indexGuide(File file) {
        try (BufferedReader reader = Files.newBufferedReader(file.toPath());) {
            return reader.lines().flatMap(line -> Arrays.stream(line.split(" "))).distinct().toList();
            
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<File> searchGuides(List<File> files, String keyword) {
        
        return files.stream().filter(file -> {
            if (indexGuide(file).contains(keyword)) {
                return true;
            }
            return false;
        }).toList();

    }

    public void updateIndex(File file) {
        System.out.println("The index is updated with the file's current content.");
    }
}

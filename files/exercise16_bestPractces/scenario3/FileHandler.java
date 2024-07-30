package files.exercise16_bestPractces.scenario3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

class DigitalLibrary {
    private Path pathToBookDatabase;
    private Path pathToUserDatabase;

    // I assume: "bookName;bookDetails"
    public String searchBook(String bookName) {
        try (BufferedReader reader = Files.newBufferedReader(pathToBookDatabase)) {
            Optional<String> result = reader.lines().filter(line -> {
                String[] data = line.split(";");
                if (data[0].matches(bookName)) {
                    return true;
                }
                return false;
            }).findAny();

            if (result.isPresent()) 
                return result.get();
            else
                return new String();

        } catch (IOException e) {
            e.printStackTrace();
            return new String();
        }
    }

    public String manageAccount(String memberID, String operation, String details) {
        try {
            Files.readAllLines(pathToUserDatabase).stream().map(line -> {
                String[] data = line.split(";");
                if (data[0].matches(memberID)) {
                    switch (operation) {
                        case "add book":
                            data[1].concat(", " + details);
                            break;
                        case "remove book":
                            data[1].replace(details, "");
                            data[1].replace(",,", ",");
                        default:
                            break;
                    }
                }
                return line;
            }).close();

            return "Book: " + details + " " + operation + " to member " + memberID + "'s" + " account";
        } catch (IOException e) {
            e.printStackTrace();
            return new String();
        }
    }
}

class FilePermissionManager {
    public String checkPermissions(String filePath) {
        try {
            return Files.getPosixFilePermissions(Paths.get(filePath)).stream().map(PosixFilePermission::toString).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return new String();
        }
    }

    public boolean changePermissions(String filePath, Set<PosixFilePermission> permissions) {
        try {
            Files.setPosixFilePermissions(Paths.get(filePath), permissions);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

class FilePerformanceManager {
    public String bufferedRead(String filePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return new String();
        }
    }

    public String bufferedWrite(String filePath, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND)) {
            writer.write(content);
            return "Operation successful";
        } catch (IOException e) {
            e.printStackTrace();
            return "Operation failed";
        }
    }
}

class ErrorHandler {
    public String safeRead(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return new String();
        }

        FilePerformanceManager manager = new FilePerformanceManager();
        return manager.bufferedRead(filePath);
    }

    public String safeWrite(String filePath, String content) {
        
        if (filePath == null || filePath.isEmpty() || content == null || content.isEmpty()) {
            return new String();
        }

        FilePerformanceManager manager = new FilePerformanceManager();
        return manager.bufferedWrite(filePath, content);

    }

    public String safeDelete(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return new String();
        }

        try {
            if (Files.deleteIfExists(Paths.get(filePath))) {
                return "Operation successful";
            }
            return "Operation failed";
        } catch (IOException e) {
            e.printStackTrace();
            return "Operation failed";
        }
    }
}

package files.exercise2_streamHandling.scenario3;


import java.io.File;
import java.io.IOException ;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Event {
    private String content;

    public Event(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class Contract {
    private String content;

    public Contract(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

public class EventManager {

    // Task 1
    public Event readEventDetails(String filePath) {
        try {
            String content = Files.readAllLines(Paths.get(filePath)).stream().collect(Collectors.joining("\n"));
            return new Event(content);
        } catch (IOException e) {
            e.printStackTrace();
            return new Event("Error parsing content");
        }
    }

    public void writeEventDetails(String filePath, Event event) {
        try {
            Files.write(Paths.get(filePath), event.getContent().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    public boolean checkPermissions(String filePath) {
        File file = Paths.get(filePath).toFile();
        return (file.canRead() && file.canWrite());
    }

    public void changePermissions(String filePath) {
        File file = Paths.get(filePath).toFile();
        file.setReadable(true);
        file.setWritable(true);
    }

    // Task 3
    public List<String> readGuestList(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addGuest(String filePath, String guest) {
        try {
            Files.write(Paths.get(filePath), guest.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
    public Contract readContract(String filePath) {
        try {
            String content = Files.readAllLines(Paths.get(filePath)).stream().collect(Collectors.joining("\n"));
            return new Contract(content);
        } catch (IOException e) {
            e.printStackTrace();
            return new Contract("Error parsing content");
        }
    }

    public void writeContract(String filePath, Contract contract) {
        try {
            Files.write(Paths.get(filePath), contract.getContent().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logError(String errorFilePath, Exception error) {
        try {
            Files.write(Paths.get(errorFilePath), error.getMessage().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

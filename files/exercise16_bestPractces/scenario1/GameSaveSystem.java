package files.exercise16_bestPractces.scenario1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

class GameProgress {
    private String data;

    public GameProgress(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}

class Game {
    // Game properties and methods
}

public class GameSaveSystem {

    // Task 1
    public boolean saveGameProgress(String filePath, GameProgress progress) {
        try {
            FileOutputStream out = new FileOutputStream(new File(filePath));
            out.write(progress.getData().getBytes());
            out.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public GameProgress loadGameProgress(String filePath) {
        try {
            String data = Files.readAllLines(Paths.get(filePath)).stream().collect(Collectors.joining("\n"));
            return new GameProgress(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 2
    public boolean checkWritePermission(String filePath) {
        return Paths.get(filePath).toFile().canWrite();
    }

    public boolean setWritePermission(String filePath) {
        return Paths.get(filePath).toFile().setReadable(true);
    }

    // Task 3
    public boolean saveGameProgressEfficiently(String filePath, GameProgress progress) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.APPEND);
            writer.write(progress.getData());
            writer.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public GameProgress loadGameProgressEfficiently(String filePath) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
            String data = reader.lines().collect(Collectors.joining("\n"));
            reader.close();
            return new GameProgress(data);
        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Task 4
    public boolean saveGameProgressRobustly(String filePath, GameProgress progress) {
        return saveGameProgressRobustly(filePath, progress);
    }

    public GameProgress loadGameProgressRobustly(String filePath) {
        return loadGameProgressRobustly(filePath);
    }

    public boolean validateGameProgress(GameProgress progress) {
        return !(progress == null || progress.getData() == null);
    }
}

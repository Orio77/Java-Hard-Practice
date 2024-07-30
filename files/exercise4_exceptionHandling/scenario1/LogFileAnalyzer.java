package files.exercise4_exceptionHandling.scenario1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class LogFileAnalyzer {
    
    public List<String> readAndFilterErrors(String filePath) {
        File file = new File(filePath);

        try (BufferedReader bReader = new BufferedReader(new FileReader(file))){
            
            return bReader.lines().filter(line -> line.contains("ERROR")).toList();

        } catch (IOException e) {
            e.printStackTrace();
        return null;
        }

    }

    public int writeErrorsToFile(List<String> errorLines, String filePath) {
        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File(filePath)));
            int lines = 0;
            for (String string : errorLines) {
                bWriter.write(string);
                lines++;
            }
            bWriter.close();
            return lines;

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void checkAndSetPermissions(String filePath) {
        File file = new File(filePath);

        if (!file.canRead()) {
            file.setReadable(true);
        }
        if (!file.canWrite()) {
            file.setWritable(true);
        }
    }

    public int writeSecureErrorsToFile(List<String> errorLines, String filePath) {
        checkAndSetPermissions(filePath);

        try {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File(filePath)));
            int lines = 0;

            for (String string : errorLines) {
                bWriter.write(string);
                lines++;
            }
            bWriter.close();
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<String> readAndFilterErrorsEfficiently(String filePath) {
        
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(new File(filePath)));
            List<String> content = bReader.lines().toList();
            bReader.close();
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public int writeErrorsToFileEfficiently(List<String> errorLines, String filePath) {
        
        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File(filePath)))) {
            int lines = 0;
            for (String string : errorLines) {
                bWriter.write(string);
                lines++;
            }
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<ErrorLog> structureErrors(List<String> errorLines) {
        List<ErrorLog> logs = new LinkedList<>();
        
        errorLines.stream().forEach(line -> {
            ErrorLog log = new ErrorLog(LocalDateTime.now().toString(), Integer.toString(line.length()), line);
            logs.add(log);
        });
        return logs;
    }

    public int writeStructuredErrorsToFile(List<ErrorLog> errorLogs, String filePath) {
        
        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File(filePath)))) {
            int lines = 0;
            for (ErrorLog errorLog : errorLogs) {
                bWriter.write("Timestamp: " + errorLog.getTimestamp().toString() + "\nError Level: " + errorLog.getErrorLevel() + "\nMessage: " + errorLog.getMessage());
                lines++;
            }
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}

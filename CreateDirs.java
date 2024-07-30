import java.io.File;
import java.io.IOException;
// AI Created (I didn't want to wait util I learn this during I/O practise, because creating those folders manually wastes a lot of my time)
public class CreateDirs {
    public static void main(String[] args) {
        createExerciseFolders("C:/Users/macie/iCloudDrive/iJava/Java_Projects/AISourcedProjects/goalPath/threads", 19);
    }

    public static void createExerciseFolders(String destinationPath, int numExercises) {
        for (int i = 1; i <= numExercises; i++) {
            String exerciseFolder = destinationPath + File.separator + "exercise" + i + "_";
            new File(exerciseFolder).mkdirs();
            for (int j = 1; j <= 3; j++) {
                String scenarioFolder = exerciseFolder + File.separator + "scenario" + j;
                new File(scenarioFolder).mkdirs();
                String taskFile = scenarioFolder + File.separator + "task" + i + j + ".md";
                File file = new File(taskFile);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    String fileName = file.getName();
                    String correctFileName = "task" + i + j + ".md";
                    if (!fileName.equals(correctFileName)) {
                        file.renameTo(new File(scenarioFolder + File.separator + correctFileName));
                    }
                }
            }
        }
    }
}
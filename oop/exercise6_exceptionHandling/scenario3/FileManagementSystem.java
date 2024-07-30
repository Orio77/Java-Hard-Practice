package oop.exercise6_exceptionHandling.scenario3;

import java.io.IOException;
import java.util.List;

public class FileManagementSystem {
    private FileManager manager;

    public void manageFiles(List<FileDetail> fileDetails) {
        for (FileDetail detail : fileDetails) {
            try {
                manager.manageFile(detail.getPath(), detail.getOperation(), detail.getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package algorithms.exercise2_search.scenario3;

import java.util.ArrayList;
import java.util.Stack;

public class Drive {
    ArrayList<Directory> directories;
    ArrayList<File> files;
    Stack<Directory> visitedDs;


    // Assume there can't be both files and directories in a directory
    // Assume files that are not in a file directory need to be organized
    // Assume moving files to the closest file directory is what's desired 
    public void organize(Directory directory) {

        if (directory == null)
            return;

        if (!visitedDs.contains(directory) && directory.getFileBase().isEmpty()) {
            visitedDs.add(directory);
            return;
        }

        if (!directory.getFileBase().isEmpty() && directory.getDirectories().isEmpty()) {
            visitedDs.add(directory);
            return;
        }

        if (!directory.getFileBase().isEmpty() && !directory.getDirectories().isEmpty()) {
            Directory fileDirectory = getFileDirectory(directory);
            if (fileDirectory != null){
                fileDirectory.getFileBase().addAll(directory.getFileBase());
                directory.getFileBase().clear();
            }
            else {
                Directory newDir = new Directory();
                directory.getDirectories().add(newDir);
                newDir.getFileBase().addAll(directory.getFileBase());
            }
        }

        for (Directory dir : directory.getDirectories()) {
            organize(dir);
        }
        
    }
    public Directory getFileDirectory(Directory directory) {
        for (Directory dir : directory.getDirectories()) {
            if (dir.getDirectories().isEmpty() && !dir.getFileBase().isEmpty())
                return dir;
        }
        Directory result = null;
        for (Directory dir : directory.getDirectories()) {
            result = getFileDirectory(dir);
            if (result != null)
                break;
        }
        return result;
    }
}

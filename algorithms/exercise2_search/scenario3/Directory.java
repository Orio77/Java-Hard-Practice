package algorithms.exercise2_search.scenario3;

import java.util.ArrayList;

public class Directory {
    private ArrayList<File> fileBase;
    private ArrayList<Directory> directories;

    public Directory() {
        fileBase = new ArrayList<>();
        directories = new ArrayList<>();
    }

    public ArrayList<File> getFileBase() {
        return fileBase;
    }
    public ArrayList<Directory> getDirectories() {
        return directories;
    }

    public File getFile(String name, int startIndex, int endIndex) {

        if (fileBase == null || fileBase.isEmpty())
            return null;
        
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        int comparison = name.compareTo(fileBase.get(midIndex).getName());

        if (comparison == 0)
            return fileBase.get(midIndex);

        File foundLeft = null;
        File foundRight = null;

        if (comparison > 0)
            foundRight = getFile(name, midIndex + 1, endIndex);
        else
            foundLeft = getFile(name, startIndex, midIndex - 1);

        if (foundLeft != null)
            return foundLeft;
        else if (foundRight != null)
            return foundRight;
        return null;
    }

    public File findLargestFile() {

        if (fileBase == null || fileBase.isEmpty())
            return null;

        File biggestFile = fileBase.get(0);
        for (File file : fileBase) {
            if (file.getSize() > biggestFile.getSize())
                biggestFile = file;
        }
        return biggestFile;
    }
}

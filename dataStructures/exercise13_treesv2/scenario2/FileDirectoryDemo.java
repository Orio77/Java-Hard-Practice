package dataStructures.exercise13_treesv2.scenario2;

public class FileDirectoryDemo {
    public static void main(String[] args) {
        Directory dir = new Directory();

        dir.generateFilesForTests(1000);
        dir.printAllFiles();
    }
}

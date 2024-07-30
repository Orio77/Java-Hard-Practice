package dataStructures.exercise3_trees.scenario1;

public class FileSystem {
    public static void main(String[] args) {
        
        FileSystemElement file1 = new FileSystemElement("file1");
        FileSystemElement file2 = new FileSystemElement("file2");
        FileSystemElement file3 = new FileSystemElement("file3");
        FileSystemElement file4 = new FileSystemElement("file4");
        FileSystemElement file5 = new FileSystemElement("file5");

        file1.addLeft(file2);
        file1.addRight(file3);
        file2.addLeft(file4);
        file4.addLeft(file5);

        FileSystemElement.listContents(file1);

        System.out.println(FileSystemElement.containsNode(file1, file4));
        System.out.println();

        FileSystemElement.delete(file5);

        FileSystemElement.listContents(file1);
    }
}

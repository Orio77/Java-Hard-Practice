package dataStructures.exercise3_trees.scenario1;

public class Directory extends FileSystemElement{

    public Directory(String name, FileSystemElement left, FileSystemElement right) {
        super(name);
        this.left = left;
        this.right = right;
    }


}

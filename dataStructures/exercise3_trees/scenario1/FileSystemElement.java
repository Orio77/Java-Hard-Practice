package dataStructures.exercise3_trees.scenario1;

public class FileSystemElement {
    FileSystemElement parent;
    String name;
    FileSystemElement left;
    FileSystemElement right;

    public FileSystemElement(String name) {
        this.name = name;
    }

    public void setParent(FileSystemElement parent) {
        this.parent = parent;
    }

    FileSystemElement getParent() {
        return parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    void addLeft(FileSystemElement fileSystemElement) {
        left = fileSystemElement;
        if (fileSystemElement != null) {
            fileSystemElement.setParent(this);
        }
    }

    void addRight(FileSystemElement fileSystemElement) {
        right = fileSystemElement;
        if (fileSystemElement != null) {
            fileSystemElement.setParent(this);
        }
    }

    FileSystemElement getLeft() {
        return left;
    }

    FileSystemElement getRight() {
        return right;
    }

    public void removeLeft() {
        this.left = null;
    }

    public void removeRight() {
        this.right = null;
    }

    public FileSystemElement getChild() {
        if (left != null)
            return left;
        else if (right != null)
            return right;
        else
            return null;
    }

    public static void delete(FileSystemElement fileSystemElement) {

        // if (fileSystemElement instanceof File) {
        //     deleteFile((File) fileSystemElement);
        // }

        // if (fileSystemElement instanceof Directory) {
        //     deleteDirectory((Directory) fileSystemElement);
        // }

        deleteDirectory(fileSystemElement);
    }

    // private static void deleteFile(File file) {
    //     removeSelf(file);
    // }

    private static void deleteDirectory(FileSystemElement directory) {

        if (directory == null) {
            return;
        }

        FileSystemElement leaf;
        while ((leaf = findLeaf(directory)) != directory) {
            removeSelf(leaf);
        }
        removeSelf(directory);
    }

    private static void removeSelf(FileSystemElement fileSystemElement) {
        if (fileSystemElement == null) 
            return;

        if (fileSystemElement.getParent().getLeft().equals(fileSystemElement))
            fileSystemElement.getParent().removeLeft();
        else
            fileSystemElement.getParent().removeRight();
    }

    private static FileSystemElement findLeaf(FileSystemElement fileSystemElement) {
        
        FileSystemElement currentElement = fileSystemElement;
        FileSystemElement tempElement = null;

        while (currentElement != null) {
            tempElement = currentElement;
            currentElement = currentElement.getChild();
        }
        return tempElement;
    }

    // Not my work
    public static boolean containsNode(FileSystemElement fileSystemElement, FileSystemElement target) {

        if (fileSystemElement == null) 
            return false;

        if (fileSystemElement.equals(target))
            return true;

        boolean isInRight = containsNode(fileSystemElement.getRight(), target);
        boolean isInLeft = containsNode(fileSystemElement.getLeft(), target);

        return isInLeft || isInRight;
    }

    public static void listContents(FileSystemElement fileSystemElement) {

        System.out.println(fileSystemElement);

        if (fileSystemElement.getLeft() != null)
            listContents(fileSystemElement.getLeft());

        if (fileSystemElement.getRight() != null)
            listContents(fileSystemElement.getRight());
    }
}
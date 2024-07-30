package dataStructures.exercise13_treesv2.scenario2;

public class Directory {
    File left;
    File right;
    File root;

    public Directory() {
        left = null;
        right = null;
        this.root = new File(100);
    }

    public void setRoot(File root) {
        this.root = root;
    }
    public File getRoot() {
        return root;
    }
    public void setLeft(File left) {
        this.left = left;
    }
    public File getLeft() {
        return left;
    }
    public void setRight(File right) {
        this.right = right;
    }
    public File getRight() {
        return right;
    }

    public File rorateLeft(File file) {
        File newFile = file.getRight();
        File smallerFile = newFile.getLeft();
        newFile.setLeft(file);
        file.setRight(smallerFile);

        file.updateHeight();
        newFile.updateHeight();

        return file;
    }

    public File rorateRight(File file) {
        File newFile = file.getLeft();
        File smallerFile = newFile.getRight();
        newFile.setRight(file);
        file.setLeft(smallerFile);

        file.updateHeight();
        newFile.updateHeight();

        return file;
    }

    public void insert(File file) {
        root = insertHelper(root, file);
    }

    public File insertHelper(File node, File file) {
        if (node == null)
            return file; 

        if (file.getValue() < node.getValue()) 
            node.setLeft(insertHelper(node.getLeft(), file));
        else if (file.getValue() > node.getValue())
            node.setRight(insertHelper(node.getRight(), file));
        else
            return node;

        node.updateHeight();
        int balance = node.calculateBalance();

        if (balance > 1 && file.getValue() < node.getLeft().getValue()) 
            return rorateRight(node);
        
        if (balance < -1 && file.getValue() > node.getRight().getValue())
            return rorateLeft(node);

        if (balance > 1 && file.getValue() > node.getLeft().getValue()) {
            node.setLeft(rorateRight(node.getLeft()));
            return rorateRight(node);
        }

        if (balance < -1 && file.getValue() < node.getRight().getValue()) {
            node.setRight(rorateRight(node.getRight()));
            return rorateLeft(node);
        }

        return node;
    }

    public void delete(File file) {
        if (file == null)
            return;

        root = deleteHelper(root, file.getValue());
    }

    public File deleteHelper(File file, int value) {
        if (file == null)
            return file;

        if (value < file.getValue())
            file.setLeft(deleteHelper(file.getLeft(), value));
        else if (value > file.getValue())
            file.setRight(deleteHelper(file.getRight(), value));
        else {
            if (file.getLeft() == null || file.getRight() == null)  {
                File temp = null;
                if (temp == file.getLeft())
                    temp = file.getRight();
                else
                    file = file.getLeft();

                if (temp == null)
                    file = null;
                else
                    file = temp;
            }
            else {
                File temp = minValueFile(file.getRight());
                file.setValue(temp.getValue());
                file.setRight(deleteHelper(file.getRight(), temp.getValue()));
            }
        }

        if (file == null)
            return file;

        file.updateHeight();
        int balance = file.calculateBalance();

        if (balance > 1) {
            if (file.getLeft().calculateBalance() >= 0)
                return rorateRight(file);
            if (file.getLeft().calculateBalance() < 0) {
                file.setLeft((rorateLeft(file.getLeft())));
                return rorateRight(file);
            }
        }

        if (balance < -1) {
            if (file.getRight().calculateBalance() >= 0)
                return rorateLeft(file);
            if (file.getRight().calculateBalance() < 0) {
                file.setRight(rorateRight(file.getRight()));
                return rorateLeft(file);
            }
        }
        return file;
    }

    private File minValueFile(File file) {
        File currFile = file;
        while (currFile.getLeft() != null) {
            currFile = currFile.getLeft();
        }
        return currFile;
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(File file) {
        if (file != null) {
            inOrderHelper(file.getLeft());
            System.out.println("Value of the file:");
            System.out.println(file.getValue());
            inOrderHelper(file.getRight());
        }
    }

    public void preOrderTraversal() {
        inOrderHelper(root);
    }

    @SuppressWarnings("unused")
    private void preOrderHelper(File file) {
        if (file != null) {
            System.out.println("Value of the file:");
            System.out.println(file.getValue());
            inOrderHelper(file.getLeft());
            inOrderHelper(file.getRight());
        }
    }

    public void postOrderTraversal() {
        inOrderHelper(root);
    }

    @SuppressWarnings("unused")
    private void postOrderHelper(File file) {
        if (file != null) {
            inOrderHelper(file.getLeft());
            inOrderHelper(file.getRight());
            System.out.println("Value of the file:");
            System.out.println(file.getValue());
        }
    }
    
    public void generateFilesForTests(int numberOfFiles) {
        File file = null;
        for (int i = 0; i < numberOfFiles; i++) {
            file = new File((int)(Math.random() * 10000));
            insert(file);
        }
    }

    public void printAllFiles() {
        printHelper(root);
    }

    public void printHelper(File file) {
        if (file == null)
            return;

        System.out.println(file);
        printHelper(file.getLeft());
        printHelper(file.getRight());
    }
}

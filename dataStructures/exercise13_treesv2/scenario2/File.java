package dataStructures.exercise13_treesv2.scenario2;

public class File {
    File left;
    File right;
    int value;
    int height;

    public File(int value) {
        this.value = value;
        left = null;
        right = null;
        height = 0;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public File getLeft() {
        return left;
    }
    public void setLeft(File left) {
        this.left = left;
    }
    public File getRight() {
        return right;
    }
    public void setRight(File right) {
        this.right = right;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public int calculateHeight(File file) {
        if (file == null)
            return -1;

        return file.getHeight();
    }

    public int calculateBalance() {
        if (left == null && right == null)
            return 0;

        return getLeftHeight() - getRightHeight();
    }

    public void updateHeight() {
        height = Math.max(getLeftHeight(), getRightHeight());
    }

    public int getLeftHeight() {
        return (left == null) ? -1 : left.getHeight();
    }

    public int getRightHeight() {
        return (right == null) ? -1 : right.getHeight();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

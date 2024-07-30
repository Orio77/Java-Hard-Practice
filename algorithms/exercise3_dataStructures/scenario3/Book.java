package algorithms.exercise3_dataStructures.scenario3;

public class Book {
    private String title;
    private Book left;
    private Book right;

    public Book(String title) {
        this.title = title;
        left = null;
        right = null;
    }

    public String getTitle() {
        return title;
    }
    public Book getLeft() {
        return left;
    }
    public Book getRight() {
        return right;
    }
    public void setLeft(Book left) {
        this.left = left;
    }
    public void setRight(Book right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return title;
    }
}

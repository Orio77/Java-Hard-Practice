package algorithms.exercise3_dataStructures.scenario3;

import java.util.ArrayList;
import java.util.LinkedList;

// The whole Book store is a BST structure. No need for book storage.
public class BookStore {
    private String name;
    private Book[] topBooks;
    private LinkedList<Book> delivery;
    private LinkedList<Book> orders;
    private LinkedList<String> updates;
    private Book root;

    public BookStore(String name) {
        this.name = name;
        topBooks = new Book[10];
        delivery = new LinkedList<>();
        orders = new LinkedList<>();
        updates = new LinkedList<>();
        root = null;
    }

    // My first BST implementation
    public boolean addBook(Book book) {
        if (book == null)
            return false;
        if (root == null)
            root = new Book(name);
        return placeBook(root, book);
    }

    private boolean placeBook(Book currentBook, Book bookToPlace) {

        int comparison = bookToPlace.getTitle().compareTo(currentBook.getTitle());

        if (currentBook.getLeft() == null && currentBook.getRight() == null) {
            if (comparison > 0) {
                currentBook.setRight(bookToPlace);
                return true;
            }
            else {
                currentBook.setLeft(bookToPlace);
                return true;
            }
        }

        if (currentBook.getLeft() == null && comparison < 0) {
            currentBook.setLeft(bookToPlace);
            return true;
        }
        if (currentBook.getRight() == null && comparison > 0) {
            currentBook.setRight(bookToPlace);
            return true;
        }

        boolean isLeft = false;
        boolean isRight = false;

        if (bookToPlace.getTitle().compareTo(currentBook.getLeft().getTitle()) < 0) {
            isLeft = placeBook(currentBook.getLeft(), bookToPlace);
        }
        else if (bookToPlace.getTitle().compareTo(currentBook.getRight().getTitle()) > 0){
            isRight = placeBook(currentBook.getRight(), bookToPlace);
        }
        else 
            return false;

        return (isLeft || isRight);
    }

    public boolean removeBook(Book book) {
        return removeBook(root, book);
    }


    private boolean removeBook(Book currentBook, Book target) {
        if (target == null || currentBook == null) {
            return false;
        }

        if (target.equals(root))
            root = null;

        int comparison = target.getTitle().compareTo(currentBook.getTitle());

        boolean foundLeft = false;
        boolean foundRight = false;

        if (comparison < 0) {
            if (currentBook.getLeft().equals(target)) {
                removeAll(currentBook.getLeft());
                removeAll(currentBook.getRight());
                currentBook.setLeft(null);
                return true;
            }
            else 
                foundLeft = removeBook(currentBook.getLeft(), target);
        }
        else if (comparison > 0) {
            if (currentBook.getRight().equals(target)) {
                removeAll(currentBook.getRight());
                removeAll(currentBook.getLeft());
                currentBook.setRight(null);
                return true;
            }
            else 
                foundRight = removeBook(currentBook.getRight(), target);
        }
        
        return (foundLeft || foundRight);
    }   

    private void removeAll(Book book) {
        if (book == null) {
            return;
        }

        if (book.getLeft() != null) 
            removeAll(book.getLeft());
        else if (book.getRight() != null)
            removeAll(book.getRight());
    }

    public Book findBook(String title) {
        return findBook(root, title);
    }

    private Book findBook(Book currentBook, String title) {

        int comparison = title.compareTo(currentBook.getTitle());

        if (comparison == 0)
            return currentBook;

        Book foundLeft = null;
        Book foundRight = null;

        if (comparison < 0) {
            if (currentBook.getLeft() == null)
                return null;
            else
                foundLeft = findBook(currentBook.getLeft(), title);
        }
        else {
            if (currentBook.getRight() == null)
                return null;
            else 
                foundRight = findBook(currentBook.getRight(), title);
        }

        if (foundLeft != null)
            return foundLeft;
        else if (foundRight != null)
            return foundRight;
        else
            return null;
    }

    public void simulateDelivery(LinkedList<Book> books) {
        for (Book book : books) {
            addBook(book);
        }
    }

    public void getOrders(ArrayList<Book> books) {
        for (Book book : books) {
            orders.push(book);
        }
    }

    public void simulateInventoryUpdatesHandling() {
        for (String update : updates) {
            System.out.println("Handled: " + update);
        }
    }

    public LinkedList<Book> getDelivery() {
        return delivery;
    }
    public String getName() {
        return name;
    }
    public Book getRoot() {
        return root;
    }
    public Book[] getTopBooks() {
        return topBooks;
    }
    public LinkedList<String> getUpdates() {
        return updates;
    }
}

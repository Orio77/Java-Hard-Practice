package dataStructures.exercise5_dynamicStructures.scenario1;

import java.util.Scanner;

public class LineOfCode {
    private LineOfCode prev;
    private LineOfCode next;
    private String content;

    public LineOfCode(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }

    public LineOfCode getPrev() {
        return prev;
    }

    public void setPrev(LineOfCode prev) {
        this.prev = prev;
    }

    public LineOfCode getNext() {
        return next;
    }

    public void setNext(LineOfCode next) {
        this.next = next;
    }

    public String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    public void linkNextLine(LineOfCode line) {
        this.setNext(line);

        if (this.next != null)
            next.setPrev(line);
    }

    public void removeNext(LineOfCode line) {
        if (this.getNext().equals(line)) {
            this.setNext(line.getNext());
            line.getNext().setPrev(this);
            line.setNext(null);
            line.setPrev(null);
        }
    }

    public void removePrev(LineOfCode line) {
        if (this.getPrev().equals(line)) {
            this.setPrev(line.getPrev());
            line.getPrev().setNext(this);
            line.setNext(null);
            line.setPrev(null);
        }
    }

    public void modify(LineOfCode line) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Current line: ");
            System.out.println(line);
            System.out.print("Please eneter a new line: ");
            String newLine = sc.nextLine();
            line.setContent(newLine);
        }
    }


    @Override
    public String toString() {
        return content;
    }
}

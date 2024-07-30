package dataStructures.exercise5_dynamicStructures.scenario1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class TextEditor {
    private HashMap<String, LineOfCode> keywordList;
    private LinkedList<LineOfCode> code;
    private LinkedList<LineOfCode> buffer;
    private int startOfText;
    private int endOfText;
    final int bufferCapacity = 20;
    final int bufferReadingCapacity = 5;

    public TextEditor() {
        keywordList = new HashMap<>();
        code = new LinkedList<>();
        buffer = new LinkedList<>();
        startOfText = 0;
        endOfText = 10;
        initializeBuffer();
    }

    public void lookUp(String keyword) {
        
        if (keywordList.get(keyword) != null) {
            System.out.println();
            System.out.println("------LOOKED UP LINE---------");
            System.out.println(keywordList.get(keyword));
            System.out.println("------LOOKED UP LINE---------");
            System.out.println();
        }
    }

    public void printPartText() {

        System.out.println("---------TEXT---------");
        for (int i = startOfText; i < endOfText; i++) {
            System.out.println(code.get(i));
        }
        System.out.println("---------END OF TEXT---------");
    }

    public void runSimulation() {

        try (Scanner sc = new Scanner(System.in)) {
            whileLoop:
            while (true) {
                printPartText();
                System.out.println();

                System.out.println("-----------MENU-----------");
                System.out.println("1. Scroll Down");
                System.out.println("2. Scroll Up");
                System.out.println("3. LookUp");
                System.out.println("x - exit");
                System.out.println();
                System.out.print("User input: ");

                String userInput = sc.nextLine();
                switch (userInput) {
                    case "1":
                        scrollDown();
                        continue;
                    case "2":
                        scrollUp();
                        continue;
                    case "3":
                        System.out.print("Please enter a keyword: ");
                        String keyword = sc.nextLine();
                        lookUp(keyword);
                        continue;
                    case "x": 
                        break whileLoop;

                    default:
                        break;
                }
            }
        }
    }

    public void scrollUp() {
        if (endOfText + 5 < code.size()) {
            endOfText = endOfText + 5;
            startOfText = startOfText + 5;
        }
    }

    public void scrollDown() {
        if (startOfText - 5 >= 0) {
            startOfText = startOfText - 5;
            endOfText = endOfText - 5;
        }
    }

    public void initializeBuffer() {

        if (code.size() > bufferCapacity) {
            for (int i = 0; i < bufferCapacity; i++) {
                buffer.add(code.get(i));
            }
        }
        else
            for (LineOfCode line : code) {
                buffer.add(line);
            }
    }

    public void readNext() {

        if (buffer.size() > 15) {
            if (buffer.size() == bufferCapacity) {
                for (int i = 0; i < bufferReadingCapacity; i++) {
                    buffer.remove(i);
                    buffer.add(code.get(endOfText + i));
                }
            }
            else
                for (int i = 0; i < bufferCapacity - buffer.size(); i++) {
                    buffer.remove(i);
                    buffer.add(code.get(endOfText + i));
                }
        }

        else {
            for (int i = 0; i < bufferReadingCapacity; i++) {
                buffer.add(code.get(endOfText + i));
                }
        }
    }

    public void readPrevious() {

        if (buffer.size() > 15) {

            if (buffer.size() == bufferCapacity) {

                for (int i = 0; i < bufferReadingCapacity; i++) {
                    buffer.removeLast();
                    buffer.addFirst(code.get(endOfText + i));
                }
            }
            else
                for (int i = 0; i < bufferCapacity - buffer.size(); i++) {
                    buffer.removeLast();
                    buffer.addFirst(code.get(endOfText + i));
                }
        }

        else {
            for (int i = 0; i < bufferReadingCapacity; i++) {
                buffer.addFirst(code.get(endOfText + i));
                }
        }
    }

    public void generateLinesForTest(int number) {

        LineOfCode head = new LineOfCode("Code Line 0");
        LineOfCode currentLine = head;

        for (int i = 1; i <= number; i++) {
            currentLine.linkNextLine(new LineOfCode("Code line " + i));
            code.add(currentLine.getNext());
            currentLine = currentLine.getNext();
        }
    }

    public HashMap<String, LineOfCode> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(HashMap<String, LineOfCode> keywordList) {
        this.keywordList = keywordList;
    }

    public LinkedList<LineOfCode> getCode() {
        return code;
    }

    public void setCode(LinkedList<LineOfCode> code) {
        this.code = code;
    }

    public int getStartOfText() {
        return startOfText;
    }

    public void setStartOfText(int startOfText) {
        this.startOfText = startOfText;
    }

    public int getEndOfText() {
        return endOfText;
    }

    public void setEndOfText(int endOfText) {
        this.endOfText = endOfText;
    }
}

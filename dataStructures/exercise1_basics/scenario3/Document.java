package dataStructures.exercise1_basics.scenario3;

import java.util.Stack;

public class Document {
    private String text;
    private Stack<String> history;
    private Stack<String> undoHistory;

    // In more advanced program, File Handling would be included
    public void addText(String newText) {
        addToHistory();
        this.text = text + " " + newText;
    }

    // In more advanced program, File Handling would be included
    public void removeText(int characterToLeave) {
        addToHistory();
        this.text = text.substring(0, characterToLeave);
        undoHistory = null;
    }

    // In more advanced program, File Handling would be included
    public void modifyText() {
        addToHistory();
        this.text = "modified text";
        undoHistory = null;
    }

    public void addToHistory() {
        history.push(this.text);
        undoHistory = null;
    }

    public void undo() {
        addToUndoHistory();
        if (history != null) {
            this.text = history.pop();
        }
    }

    public void addToUndoHistory() {
        if (history != null) {
            undoHistory.push(history.peek());
        }
    }

    public void redo() {
        if (undoHistory != null) {
            this.text = undoHistory.pop();
        }
    }
}

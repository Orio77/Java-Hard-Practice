package generics.exercise3_wildcards.scenario2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Message<T> {
    private List<T> attachedFiles;

    public Message() {
        attachedFiles = new ArrayList<>();
    }
    
    public boolean attachFile(T file) {
        return attachedFiles.add(file);
    }

    public void displayAttachment() {
        System.out.println("Attached files: ");
        for (int i = 0; i < attachedFiles.size(); i++) {
            System.out.println(i + ". " + attachedFiles.get(i));
        }
    }

    public T downloadAttachment(int index) {
        return attachedFiles.get(index);
    }

    public Stream<T> processAttachment() {
        return attachedFiles.stream();
    }

    public List<T> getAttachedFiles() {
        return Collections.unmodifiableList(attachedFiles);
    }
}

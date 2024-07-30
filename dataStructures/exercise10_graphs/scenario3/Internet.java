package dataStructures.exercise10_graphs.scenario3;

import java.util.LinkedList;

public class Internet {
    LinkedList<WebPage> internet;

    public void addPage(WebPage page) {
        internet.add(page);
    }

    public LinkedList<WebPage> getInternet() {
        return internet;
    }
}

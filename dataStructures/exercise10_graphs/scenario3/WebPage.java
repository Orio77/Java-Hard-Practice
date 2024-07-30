package dataStructures.exercise10_graphs.scenario3;

import java.util.LinkedList;

// TODO PROBLEM 1
public class WebPage implements Comparable<WebPage> {
    LinkedList<Link> links;
    int distance;

    public WebPage() {
        links = new LinkedList<>();
        distance = Integer.MAX_VALUE;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void addLink(WebPage page, int weight) {
        links.add(new Link(this, page, weight));
    }

    public LinkedList<Link> getLinks() {
        return links;
    }

    @Override
    public int compareTo(WebPage page) {
        return Integer.compare(this.distance, page.getDistance());
    }
}

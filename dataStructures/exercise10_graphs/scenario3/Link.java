package dataStructures.exercise10_graphs.scenario3;

public class Link {
    WebPage page1;
    WebPage page2;
    int weight;

    public Link(WebPage page1, WebPage page2, int weight) {
        this.page1 = page1;
        this.page2 = page2;
        this.weight = weight;
    }

    public WebPage getPage1() {
        return page1;
    }

    public WebPage getPage2() {
        return page2;
    }

    public int getWeight() {
        return weight;
    }
}

package streamAPI.exercise18_documentation.scenario2;

import java.util.List;

public class Paper {
    private String title;
    private List<String> authors;
    private int year;
    private int citations;
    private List<String> keywords;

    public List<String> getAuthors() {
        return authors;
    }
    public int getCitations() {
        return citations;
    }
    public List<String> getKeywords() {
        return keywords;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
}

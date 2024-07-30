package generics.exercise4_typeErasure.scenario1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseContent<T> {
    private List<T> contentList;
    private Class<T> type;

    public CourseContent() {
        contentList = new ArrayList<>();
    }

    public boolean addContent(T content) {
        return contentList.add(content);
    }

    public T getContent(int index) {
        return contentList.get(index);
    }

    public List<T> getContentList() {
        return Collections.unmodifiableList(contentList);
    }

    public Class<T> getType() {
        return type;
    }
}

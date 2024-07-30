package generics.exercise4_typeErasure.scenario1;

public class TypeSafeProcessor {
    
    public void processContent(CourseContent<? extends CourseContent<?>> content) {
        System.out.println(content.getContentList());
    }
}

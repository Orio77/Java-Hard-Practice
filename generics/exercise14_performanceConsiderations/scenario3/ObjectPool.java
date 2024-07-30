package generics.exercise14_performanceConsiderations.scenario3;

import java.util.Stack;
import java.util.function.Supplier;

public class ObjectPool<T> {
    private Stack<T> pool;
    //AI Helped
    private Supplier<T> creator;

    public ObjectPool(Supplier<T> creator) {
        pool = new Stack<>();
        this.creator = creator;
    }

    public T acquire() {
        if (pool.empty()) {
            return creator.get();
        }
        return pool.pop();
    }

    public void release(T object) {
        pool.push(object);
    }
}

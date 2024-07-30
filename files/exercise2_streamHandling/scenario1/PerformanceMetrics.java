package files.exercise2_streamHandling.scenario1;

import java.util.Stack;

public class PerformanceMetrics {
    private Stack<Long> performanceLog;

    public void addMetrics(long duration) {
        performanceLog.push(duration);
    }
}

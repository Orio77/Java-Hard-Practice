package generics.exercise15.scenario1;

import java.util.ArrayList;
import java.util.List;

public class TestSuite<T> {
    private List<Test<T>> tests;

    public TestSuite() {
        tests = new ArrayList<>();
    }

    public boolean addTest(Test<T> test) {
        return tests.add(test);
    }

    public List<Boolean> runTests() {
        List<Boolean> results = new ArrayList<>();

        for (Test<T> test : tests) {
            if (test.getSimulation().toString().matches(test.getExepectedResult())) {
                results.add(true);
            }
            else {
                results.add(false);
            }
        }

        return results;
    }

    public List<Test<T>> getTests() {
        return tests;
    }
}

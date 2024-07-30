package oop.exercise13_garbageCollection.scenario3;

public class DemoClass {
    private static int instances;

    public static void displayInstanceCount() {
        System.out.println("Number Of Objects: " + instances);
    }

    public static int getInstances() {
        return instances;
    }
    public static void setInstances(int instances) {
        DemoClass.instances = instances;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Object is being collected");
    }
}

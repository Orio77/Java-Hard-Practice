package dataStructures.exercise14_optimization.scenario2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// A simple 3D point class
class Point3D {
    private double x, y, z;

    Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public int getHash() {
        return Double.hashCode(x);
    }
}

// A simple 3D object class
class Object3D {
    private List<Point3D> points;
    private HashMap<Integer, Point3D> cache;

    Object3D() {
        points = new ArrayList<>();
        cache = new HashMap<>();
    }

    void addPoint(Point3D point) {
        points.add(point);
        cache.put(point.getHash(), point);
    }

    // Inefficient rendering method
    void render() {
        for (Point3D point : points) {
            // Simulate rendering by just printing the points
            System.out.println("Rendering point at (" + point.getX() + ", " + point.getY() + ", " + point.getZ() + ")");
        }
    }

    void renderOpt() {
        System.out.println(cache.values());
    }
}

// The main application class
public class GraphicsApplication {
    private List<Object3D> objects;
    private boolean rendered;

    GraphicsApplication() {
        objects = new ArrayList<>();
        rendered = false;
    }

    void addObject(Object3D object) {
        objects.add(object);
        if (rendered)
            object.render();
    }

    // The main rendering loop
    void renderLoop() {
        while (true) {
            for (Object3D object : objects) {
                object.render();
            }
        }
    }

    void renderOpt() {
        if (rendered)
            return;
            
        for (Object3D object : objects) {
            object.render();
        }
        rendered = true;
    }

    public static void main(String[] args) {
        GraphicsApplication app = new GraphicsApplication();

        // Create some 3D objects and add them to the application
        Object3D obj1 = new Object3D();
        obj1.addPoint(new Point3D(1, 2, 3));
        obj1.addPoint(new Point3D(4, 5, 6));
        app.addObject(obj1);

        app.renderOpt();

        Object3D obj2 = new Object3D();
        obj2.addPoint(new Point3D(7, 8, 9));
        obj2.addPoint(new Point3D(10, 11, 12));
        app.addObject(obj2);

        // Start the rendering loop
        // app.renderLoop();
        app.renderOpt();
    }
}




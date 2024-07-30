package generics.exercise6_boundedTypeParams.scenario3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Particle {
    private double mass;
    private double velocity;
    private List<Particle> intercationParticles;

    public Particle(double mass, double velocity) {
        this.mass = mass;
        this.velocity = velocity;
        intercationParticles = new ArrayList<>();
    }

    public double getMass() {
        return mass;
    }
    public double getVelocity() {
        return velocity;
    }
    public List<Particle> getIntercationParticles() {
        return Collections.unmodifiableList(intercationParticles);
    }
}

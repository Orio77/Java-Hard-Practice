package generics.exercise6_boundedTypeParams.scenario3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForceCalculator<T extends Particle> {
    
    public double calculateForce(T particle1, T particle2) {
        double distance = 1; // for simplicity
        // gravitational constant is omitted in the equation

        return (particle1.getMass() * particle2.getMass()) / (distance * distance);
    }


    public double calculateTotalForce(List<T> particles, T targetParticle) {

        double totalForce = 0;

        for (T t : particles) {
            totalForce += calculateForce(t, targetParticle);
        }

        return totalForce;
    }

    public Map<T, Double> calculateAllAccelerations(List<T> particles) {
        
        Map<T, Double> accelerations = new HashMap<>();

        for (T particle : particles) {
            double totalForce = calculateTotalForce(particles, particle);
            double acceleration = PhysicsUtils.calculateAcceleration(particle, totalForce);
            accelerations.put(particle, acceleration);
        }
        return accelerations;
    }
}

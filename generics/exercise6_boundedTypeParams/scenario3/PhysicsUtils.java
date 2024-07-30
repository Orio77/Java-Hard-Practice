package generics.exercise6_boundedTypeParams.scenario3;

public class PhysicsUtils {
    

    public static <T extends Particle> double calculateAcceleration(T particle, double force) {

        return force / particle.getMass();
    }
}

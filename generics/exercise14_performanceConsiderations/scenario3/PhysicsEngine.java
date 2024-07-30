package generics.exercise14_performanceConsiderations.scenario3;

public class PhysicsEngine<T extends GameObject<?>> extends GameObjectCollection<T>{
    

    public boolean detectCollision(T gameObject1, T gameObject2) {
        if (gameObject1.getPosition() == gameObject2.getPosition()) 
            return true;
        
        return false;
    }
}

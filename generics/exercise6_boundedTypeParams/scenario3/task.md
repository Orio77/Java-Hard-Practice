You are working on a scientific simulation tool that models physical phenomena. Your task is to develop a generic method for calculating forces between particles, but restrict the method to work only with classes representing particles.

**Task 1: Bounded Type Parameters**

Create a class `Particle` with properties `mass` and `velocity`. Now, create a generic class `ForceCalculator<T extends Particle>` with a method `calculateForce(T particle1, T particle2)`. This method should calculate and return the force between two particles using the formula `F = m1 * m2 / d^2`, where `m1` and `m2` are the masses of the particles and `d` is the distance between them (for simplicity, assume `d = 1`).

**Task 2: Bounded Type Parameters + Generics in Collections**

Create a method `calculateTotalForce(List<T> particles)` in the `ForceCalculator` class. This method should calculate and return the total force exerted by all particles in the list on a given particle.

**Task 3: Bounded Type Parameters + Generic Methods**

Create a static generic method `calculateAcceleration(T particle, double force)` in a utility class `PhysicsUtils`. This method should calculate and return the acceleration of a particle when a certain force is applied, using the formula `a = F / m`, where `F` is the force and `m` is the mass of the particle.

**Task 4: Bounded Type Parameters + Generics in Collections + Generic Methods**

Create a method `calculateAllAccelerations(List<T> particles)` in the `ForceCalculator` class. This method should calculate and return a `Map<T, Double>` where the keys are the particles and the values are the accelerations of the particles when the total force calculated in Task 2 is applied.


# Documentation

## Classes to Create

1. `Particle`
2. `ForceCalculator<T extends Particle>`
3. `PhysicsUtils`

## Class Methods to Implement

### Class: `Particle`

1. `getMass`: This method should return the mass of the particle.
2. `getVelocity`: This method should return the velocity of the particle.

### Class: `ForceCalculator<T extends Particle>`

1. `calculateForce`: This method should take two particles and calculate the force between them using the formula `F = m1 * m2 / d^2`, where `m1` and `m2` are the masses of the particles and `d` is the distance between them (for simplicity, assume `d = 1`).
    
2. `calculateTotalForce`: This method should take a list of particles and calculate the total force exerted by all particles in the list on a given particle.
    
3. `calculateAllAccelerations`: This method should take a list of particles and calculate the acceleration of each particle when the total force calculated in `calculateTotalForce` is applied. It should return a `Map<T, Double>` where the keys are the particles and the values are the accelerations.
    

### Class: `PhysicsUtils`

1. `calculateAcceleration`: This method should be a static generic method that takes a particle and a force, and calculates the acceleration of the particle when the force is applied, using the formula `a = F / m`, where `F` is the force and `m` is the mass of the particle.

## General Overview

The `Particle` class represents a particle with properties `mass` and `velocity`. The `ForceCalculator` class is a generic class that operates on objects of type `T`, where `T` extends `Particle`. It has methods to calculate the force between two particles, the total force exerted by a list of particles on a given particle, and the accelerations of a list of particles when the total force is applied.

The `PhysicsUtils` class is a utility class that contains a static generic method to calculate the acceleration of a particle when a certain force is applied.

## Example Workflow

1. Create `Particle` objects with given mass and velocity.
    
2. Create a `ForceCalculator` object.
    
3. Use the `calculateForce` method to calculate the force between two particles.
    
4. Use the `calculateTotalForce` method to calculate the total force exerted by a list of particles on a given particle.
    
5. Use the `calculateAllAccelerations` method to calculate the accelerations of a list of particles when the total force is applied.
    
6. Use the `PhysicsUtils.calculateAcceleration` method to calculate the acceleration of a particle when a certain force is applied.
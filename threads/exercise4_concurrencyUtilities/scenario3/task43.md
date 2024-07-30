**Task 1: Thread Synchronization and Inter-thread Communication**

You are tasked with developing a part of an Intelligent Building Management System. Specifically, you need to manage the HVAC (Heating, Ventilation, and Air Conditioning) system and the Lighting system. These two systems need to work in harmony to ensure energy efficiency and occupant comfort.

**Function 1: `synchronizeSystems(HVAC hvac, Lighting lighting)`** This function should start two threads: one for the HVAC system and one for the Lighting system. The HVAC system should not operate if the Lighting system is in 'energy saving' mode and vice versa. Use synchronization to ensure this.

**Function 2: `communicateStatus(HVAC hvac, Lighting lighting)`** This function should allow the HVAC and Lighting systems to communicate their status to each other. If one system changes its status (e.g., from 'normal' to 'energy saving'), it should notify the other system.

Example: If the Lighting system is in 'energy saving' mode, the HVAC system should also switch to 'energy saving' mode to conserve energy.

**Task 2: Thread Pools and Atomic Variables**

**Main Topic:** Intelligent Building Management System

**Selected Topic:** Thread Pools and Atomic Variables

You are to manage the security system of the building. The security system has multiple components (e.g., cameras, alarms) that need to be monitored concurrently.

**Function 1: `initializeSecuritySystem(SecuritySystem securitySystem)`** This function should create a thread pool and assign each component of the security system to a separate thread.

**Function 2: `monitorSecuritySystem(SecuritySystem securitySystem)`** This function should monitor the status of each component. If a component fails (e.g., a camera stops working), it should increment an atomic variable `failedComponents`.

Example: If two cameras and one alarm fail, `failedComponents` should be 3.

**Task 3: Executors Framework and Handling InterruptedException**

**Main Topic:** Intelligent Building Management System

**Selected Topic:** Executors Framework and Handling InterruptedException

You are tasked with managing the elevators in the building.

**Function 1: `operateElevators(ElevatorSystem elevatorSystem)`** This function should use the Executors framework to manage the elevators. Each elevator should be a separate task.

**Function 2: `handleInterruptions(ElevatorSystem elevatorSystem)`** This function should handle any interruptions (e.g., an elevator breaking down) gracefully. If an elevator breaks down, it should be removed from the ExecutorService and a message should be logged.

Example: If Elevator 2 breaks down, it should be removed from the ExecutorService and a message "Elevator 2 has broken down" should be logged.

**Task 4: Fork/Join Framework and Parallel Algorithms Implementation**

**Main Topic:** Intelligent Building Management System

**Selected Topic:** Fork/Join Framework and Parallel Algorithms Implementation

You are tasked with managing the power distribution in the building.

**Function 1: `distributePower(PowerSystem powerSystem)`** This function should use the Fork/Join framework to distribute power to different parts of the building. Each part of the building (e.g., a floor) should be a separate task.

**Function 2: `calculatePowerUsage(PowerSystem powerSystem)`** This function should calculate the total power usage of the building. It should use a parallel algorithm to speed up the calculation.

**Function 3: `optimizePowerUsage(PowerSystem powerSystem)`** This function should optimize the power usage of the building. It should turn off unnecessary systems (e.g., lights in unoccupied rooms) to save power.

Example: If the total power usage is above a certain threshold, the `optimizePowerUsage` function should be called to reduce power usage.
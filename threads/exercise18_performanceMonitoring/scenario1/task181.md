**Task 1: Traffic Light Control System with Thread Priorities**

You are tasked with implementing a traffic light control system that uses thread priorities to manage traffic flow.

**Function 1:** `adjustTrafficFlow(int[] trafficCounts)`: This method takes in an array of traffic counts for each direction (North, South, East, West). It should adjust the priorities of the threads controlling the traffic lights based on the traffic counts. The direction with the highest traffic count should have the highest priority.

**Function 2:** `controlTraffic()`: This method should control the traffic lights based on their priorities. The traffic light with the highest priority should be green for the longest time. Ensure that the traffic lights are synchronized to avoid collisions.

Example:

Input: `adjustTrafficFlow(new int[]{100, 200, 150, 50})`

Output: The South direction should have the highest priority and hence, the longest green light duration.

---

**Task 2: Traffic Light Control System with Concurrency Utilities**

For this task, you will focus on the use of concurrency utilities in Java to manage the traffic light system.

**Function 1:** `initiateTrafficLights()`: This method should initiate a ScheduledExecutorService that changes the state of the traffic lights at fixed intervals.

**Function 2:** `adjustLightDuration(int[] trafficCounts)`: This method should adjust the duration for which each traffic light is green, based on the traffic counts for each direction. Use a Phaser to ensure that all traffic lights are updated before the next cycle begins.

Example:

Input: `adjustLightDuration(new int[]{120, 80, 150, 100})`

Output: The East direction should have the longest green light duration.

---

**Task 3: Traffic Light Control System with Lock Objects**

In this task, you will use Lock objects to manage the traffic light system.

**Function 1:** `toggleTrafficLights()`: This method should toggle the state of the traffic lights. Use a ReentrantLock to ensure that only one traffic light can change state at a time.

**Function 2:** `adjustLightSequence(int[] trafficCounts)`: This method should adjust the sequence in which the traffic lights change, based on the traffic counts for each direction. Use a Condition object to ensure that the traffic lights change in the correct order.

Example:

Input: `adjustLightSequence(new int[]{70, 90, 110, 130})`

Output: The sequence of traffic lights should be West, East, South, North.

---

**Task 4: Traffic Light Control System with Fork/Join Framework**

In this task, you will use the Fork/Join framework to manage the traffic light system.

**Function 1:** `initiateTrafficSystem()`: This method should initiate the traffic light system. Use a RecursiveAction to start the traffic lights in all directions.

**Function 2:** `adjustTrafficFlow(int[] trafficCounts)`: This method should adjust the flow of traffic based on the traffic counts for each direction. Use a RecursiveTask to calculate the optimal traffic flow for each direction.

**Function 3:** `monitorTraffic()`: This method should monitor the traffic and adjust the traffic flow as necessary. Use the Fork/Join framework to perform these tasks concurrently.

Example:

Input: `adjustTrafficFlow(new int[]{200, 100, 150, 50})`

Output: The North direction should have the highest traffic flow.
**Task 1: Sensor Data Processing and Decision Making**  
In the context of autonomous vehicles, sensor data processing and decision making are crucial. Implement two methods: `processSensorData` and `makeDecision`. The `processSensorData` method should simulate the processing of sensor data using threads. It should take in a list of sensor data and process each data point in a separate thread. The `makeDecision` method should simulate making decisions based on the processed data. It should wait for all the sensor data to be processed before making a decision. Use synchronization mechanisms to ensure that decisions are made only after all data has been processed.

Example:  
Input: `processSensorData(["data1", "data2", "data3"])`  
Output: `Data processed: data1, data2, data3`

Input: `makeDecision()`  
Output: `Decision made based on processed data`

**Task 2: Inter-thread Communication**  
Considering the topic of Inter-thread Communication, implement two methods: `sendData` and `receiveData`. The `sendData` method should simulate sending data from one vehicle to another. The `receiveData` method should simulate receiving data. Use inter-thread communication to ensure that data is received only after it has been sent.

Example:  
Input: `sendData("Hello")`  
Output: `Data sent: Hello`

Input: `receiveData()`  
Output: `Data received: Hello`

**Task 3: Thread Pools and Deadlock Avoidance**  
With the topic of Thread Pools and Deadlock Avoidance in mind, implement two methods: `initiateCommunication` and `manageThreads`. The `initiateCommunication` method should simulate initiating communication between multiple vehicles. The `manageThreads` method should manage the threads used for communication to avoid deadlock. Use a thread pool to manage the threads and implement a deadlock avoidance algorithm.

Example:  
Input: `initiateCommunication(["Vehicle1", "Vehicle2", "Vehicle3"])`  
Output: `Communication initiated between Vehicle1, Vehicle2, Vehicle3`

Input: `manageThreads()`  
Output: `Threads managed to avoid deadlock`

**Task 4: Thread Safety and Lock Objects**  
Considering the topic of Thread Safety and Lock Objects, implement three methods: `accessSharedResource`, `lockResource`, and `unlockResource`. The `accessSharedResource` method should simulate accessing a shared resource. The `lockResource` and `unlockResource` methods should lock and unlock the resource respectively. Use lock objects to ensure thread safety when accessing the shared resource.

Example:  
Input: `lockResource()`  
Output: `Resource locked`

Input: `accessSharedResource()`  
Output: `Shared resource accessed`

Input: `unlockResource()`  
Output: `Resource unlocked`
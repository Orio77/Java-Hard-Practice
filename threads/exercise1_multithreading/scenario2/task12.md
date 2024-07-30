**Task 1**

**Problem:** Implement a `MeterReader` and `GridController` class that simulate the interaction between smart meters and the grid controller in a smart grid system. The `MeterReader` class should have a method `sendData()` that sends data to the `GridController`. The `GridController` class should have a method `receiveData()` that receives data from the `MeterReader`. Use multithreading to simulate multiple `MeterReader` instances sending data concurrently to the `GridController`. Use synchronization mechanisms to ensure that the `GridController` receives data from one `MeterReader` at a time.

**Example:** If we have three `MeterReader` instances (m1, m2, m3) each sending data ("Data from m1", "Data from m2", "Data from m3") to the `GridController`, the `GridController` should receive and print the data one at a time.

---

**Task 2**

**Topic:** Thread Pools

**Problem:** Implement a `SmartGrid` class that uses a thread pool to manage multiple `MeterReader` instances. The `SmartGrid` class should have a method `addMeter(MeterReader meter)` that adds a `MeterReader` to the thread pool and a method `shutdown()` that stops the thread pool. Each `MeterReader` should have a method `readData()` that reads data and sends it to the `GridController`. Use the Executors framework to create the thread pool.

**Example:** If we create a `SmartGrid` with a thread pool of size 2 and add three `MeterReader` instances (m1, m2, m3), the `SmartGrid` should manage the execution of the `MeterReader` instances so that only two are running at any given time.

---

**Task 3**

**Topic:** Atomic Variables

**Problem:** Implement a `MeterReader` class that uses atomic variables to count the number of data readings sent to the `GridController`. The `MeterReader` class should have a method `sendData()` that sends data to the `GridController` and increments the count of data readings. The `GridController` class should have a method `receiveData()` that receives data from the `MeterReader`. Use multithreading to simulate multiple `MeterReader` instances sending data concurrently to the `GridController`.

**Example:** If we have three `MeterReader` instances (m1, m2, m3) each sending data 5 times to the `GridController`, the total count of data readings should be 15.

---

**Task 4**

**Topic:** Fork/Join Framework

**Problem:** Implement a `DataAnalyzer` class that uses the Fork/Join framework to analyze data readings from multiple `MeterReader` instances. The `DataAnalyzer` class should have a method `analyzeData(List<String> data)` that analyzes the data and returns the result. The analysis process should be divided into subtasks that can be executed in parallel using the Fork/Join framework.

**Example:** If we have a `DataAnalyzer` instance and a list of 1000 data readings, the `analyzeData()` method should divide the list into sublists, analyze each sublist in parallel, and return the combined result.
**Task 1**

**Problem:** Implement a class `DataTransferManager` that simulates the transfer of data across servers in a CDN. The class should have two methods:

1. `initiateTransfer(int dataSize, int numberOfServers)`: This method should initiate the transfer of `dataSize` amount of data across `numberOfServers` servers. The data should be evenly distributed across all servers. The method should use threads to simulate parallel data transfer.
    
2. `getTransferStatus()`: This method should return a list of all the servers with the amount of data they currently hold. The method should ensure thread safety when accessing the data.
    

**Input:** `initiateTransfer(1000, 5)`, `getTransferStatus()`

**Output:** `[{server1: 200}, {server2: 200}, {server3: 200}, {server4: 200}, {server5: 200}]`

**Task 2**

**Topic:** Synchronization

**Problem:** Implement a class `SynchronizedDataTransferManager` that extends the `DataTransferManager` class. This class should override the `initiateTransfer` and `getTransferStatus` methods to ensure that data transfer and access are synchronized.

**Input:** `initiateTransfer(1000, 5)`, `getTransferStatus()`

**Output:** `[{server1: 200}, {server2: 200}, {server3: 200}, {server4: 200}, {server5: 200}]`

**Task 3**

**Topic:** Thread Pools

**Problem:** Implement a class `ThreadPoolDataTransferManager` that extends the `DataTransferManager` class. This class should override the `initiateTransfer` method to use a thread pool instead of creating new threads for each data transfer. The size of the thread pool should be equal to the number of servers.

**Input:** `initiateTransfer(1000, 5)`, `getTransferStatus()`

**Output:** `[{server1: 200}, {server2: 200}, {server3: 200}, {server4: 200}, {server5: 200}]`

**Task 4**

**Topic:** Atomic Variables

**Problem:** Implement a class `AtomicDataTransferManager` that extends the `DataTransferManager` class. This class should override the `initiateTransfer` and `getTransferStatus` methods to use atomic variables for data transfer and access to ensure thread safety. The class should also have a third method:

3. `getTotalDataTransferred()`: This method should return the total amount of data transferred so far. The method should use an atomic variable to keep track of the total data transferred.

**Input:** `initiateTransfer(1000, 5)`, `getTransferStatus()`, `getTotalDataTransferred()`

**Output:** `[{server1: 200}, {server2: 200}, {server3: 200}, {server4: 200}, {server5: 200}]`, `1000`
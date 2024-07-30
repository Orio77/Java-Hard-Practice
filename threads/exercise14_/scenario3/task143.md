**Task 1: Thread Synchronization and Inter-thread Communication**

Problem: You are given a manufacturing unit that tests two different aspects of a product concurrently. The first test is a `physicalTest()` and the second is a `chemicalTest()`. These tests should be performed in parallel, but the `chemicalTest()` can only start after the `physicalTest()` has completed. Implement these methods using thread synchronization and inter-thread communication.

Example: If `physicalTest()` takes 5 seconds to complete and `chemicalTest()` takes 3 seconds, the total time should not exceed 5 seconds as they are running concurrently.

**Task 2: Thread Pools and Atomic Variables**

Topic: Atomic Variables

Problem: In a manufacturing unit, multiple products are tested concurrently using a thread pool. Each product has a unique ID and the test result is either pass or fail. Implement a method `testProduct()` that tests a product and updates an atomic variable `passedTests` if the test is successful. Use a thread pool to test multiple products concurrently.

Example: If there are 10 products and 7 pass the test, `passedTests` should be 7.

**Task 3: Executors Framework and Handling InterruptedException**

Topic: Handling InterruptedException

Problem: In a manufacturing unit, a set of products are tested concurrently using the Executors framework. Each product requires a different time to test. If a test takes more than a certain time, it should be interrupted and the product should be marked as 'Test Failed'. Implement two methods, `startTest()` that starts the test for a product and `stopTest()` that stops the test if it exceeds the time limit.

Example: If a product's test exceeds the time limit, the test should be stopped and the product should be marked as 'Test Failed'.

**Task 4: Fork/Join Framework and Parallel Algorithms Implementation**

Topic: Parallel Algorithms Implementation

Problem: A manufacturing unit tests a batch of products. Each batch can be divided into smaller sub-batches and tested in parallel. Implement three methods using the Fork/Join framework: `divideBatch()` that divides a batch into sub-batches, `testSubBatch()` that tests a sub-batch, and `combineResults()` that combines the results of all sub-batches.

Example: If a batch of 100 products is divided into 10 sub-batches, each sub-batch should be tested in parallel and the results should be combined at the end.
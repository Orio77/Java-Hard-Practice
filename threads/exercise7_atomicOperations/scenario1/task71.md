**Task 1: Atomic Operations with Basic Thread Management**  
Given a high-resolution image, implement two methods: `applyFilterConcurrently` and `getProcessingTime`. The `applyFilterConcurrently` method should apply a given filter to the image using multiple threads, with each thread handling a portion of the image. The `getProcessingTime` method should return the time taken to apply the filter. Use atomic variables to ensure thread safety.

Example:  
Input: High-resolution image, Filter  
Output: Filtered image, Processing time

**Task 2: Atomic Operations with Thread Pools**  
Given a batch of high-resolution images and a filter, implement two methods: `applyFilterToBatch` and `getAverageProcessingTime`. The `applyFilterToBatch` method should apply the filter to each image in the batch using a thread pool, with each thread handling one image. The `getAverageProcessingTime` method should return the average time taken to apply the filter to an image. Use atomic variables to ensure thread safety and to calculate the average processing time.

Example:  
Input: Batch of high-resolution images, Filter  
Output: Batch of filtered images, Average processing time

**Task 3: Atomic Operations with Executors Framework**  
Given a high-resolution image and a set of filters, implement two methods: `applyFiltersConcurrently` and `getTotalProcessingTime`. The `applyFiltersConcurrently` method should apply each filter to the image concurrently using the Executors framework, with each executor handling one filter. The `getTotalProcessingTime` method should return the total time taken to apply all filters. Use atomic variables to ensure thread safety and to calculate the total processing time.

Example:  
Input: High-resolution image, Set of filters  
Output: Filtered image, Total processing time

**Task 4: Atomic Operations with Fork/Join Framework**  
Given a high-resolution image and a complex transformation that can be broken down into smaller tasks, implement three methods: `applyTransformationConcurrently`, `getProcessingTime`, and `getNumberOfTasks`. The `applyTransformationConcurrently` method should apply the transformation to the image using the Fork/Join framework, with each fork handling a portion of the image. The `getProcessingTime` method should return the time taken to apply the transformation. The `getNumberOfTasks` method should return the number of tasks created during the process. Use atomic variables to ensure thread safety, to calculate the processing time, and to count the number of tasks.

Example:  
Input: High-resolution image, Complex transformation  
Output: Transformed image, Processing time, Number of tasks
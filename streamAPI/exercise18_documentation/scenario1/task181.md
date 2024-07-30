Background: A healthcare database contains patient records with varying formats. The task is to standardize the data format for analysis.

Main Topic: Stream API code Documentation
  
List: [Stream Basics, Lambda Expressions, Stream Terminating Operations, Stream Collectors, Handling Null Values, Parallel Stream, Exception Handling, Stream Performance, Stream API with Data Structures, Custom Collectors, Method References, Optional, Stream Ordering, Error Handling Strategies, Testing Stream Code, Code Readability, Documentation, Performance Optimization]

**Problem: Advanced Stream API Application**

# Problem Introduction

(In the healthcare database, patient records are stored in varying formats. This inconsistency makes it difficult to perform efficient data analysis. Your task is to develop a system that uses the Stream API to standardize these records.

The system should be able to read the patient records, transform the data into a standardized format, and then store the transformed data for further analysis. The transformation process should be efficient and handle any inconsistencies in the data, such as null values or different data types.
In this series of tasks, you will be challenged to apply various Stream API concepts to solve increasingly complex problems related to this scenario.)

**Level 1: Difficulty 5/10**

(In this task, you are required to implement a method named `standardizeRecords` that will take a `List<String>` as input, representing the patient records in varying formats. Each record is a string that contains patient information separated by a comma. The information includes patient ID, name, age, and medical condition. However, the order of information is not consistent across all records.

Your task is to use the Stream API to transform these records into a standardized format. The standardized format should be a `List<PatientRecord>` where `PatientRecord` is a class that you need to define. The `PatientRecord` class should have four fields: `id`, `name`, `age`, and `condition`.

The `standardizeRecords` method should perform the following operations:

1. Split each record into its constituent parts.
2. Identify the type of each part based on its content (IDs are numeric, ages are numeric, names are alphabetic, and conditions are any other string).
3. Create a `PatientRecord` object for each record, ensuring that the fields are correctly assigned based on the identified types.
4. Return a list of `PatientRecord` objects.

Note: You can assume that each record will always contain exactly four parts, and each part will be correctly identifiable based on its content.)

**Level 2: Difficulty 6/10**

(Topic: Stream Collectors

In this task, you are required to implement a method named `groupRecordsByCondition` that will take a `List<PatientRecord>` as input, representing the standardized patient records.

Your task is to use the Stream API and specifically the Collectors to group these records based on the medical condition of the patients. The output should be a `Map<String, List<PatientRecord>>` where the key is the medical condition and the value is a list of `PatientRecord` objects of patients having that condition.

The `groupRecordsByCondition` method should perform the following operations:

1. Use the Stream API to process the list of `PatientRecord` objects.
2. Use a Collector to group the records by the medical condition.

Note: You can assume that the medical condition is always a non-null and non-empty string.)

**Level 3: Difficulty 7/10**

(Topic: Handling Null Values and Optional

In this task, you are required to implement a method named `filterRecordsByAge` that will take a `List<PatientRecord>` as input, representing the standardized patient records.

Your task is to use the Stream API to filter these records based on the age of the patients. The output should be a `List<PatientRecord>` where each `PatientRecord` object represents a patient who is at least 18 years old.

However, due to inconsistencies in the data, some records may have null or non-numeric age values. You need to handle these null values gracefully using the Optional class and filter out any records with non-numeric age values.

The `filterRecordsByAge` method should perform the following operations:

1. Use the Stream API to process the list of `PatientRecord` objects.
2. Use the Optional class to handle any null age values.
3. Filter out any records with non-numeric age values.
4. Filter the records to include only patients who are at least 18 years old.

Note: You can assume that the age is a string that should be converted to an integer for the comparison.)

**Level 4: Difficulty 8/10**

(Topic: Parallel Stream and Performance Optimization

In this task, you are required to implement a method named `optimizeProcessing` that will take a `List<PatientRecord>` as input, representing the standardized patient records.

Your task is to use the Stream API to process these records in parallel, aiming to improve the performance of the data transformation process. The output should be a `List<PatientRecord>` where each `PatientRecord` object represents a patient who is at least 18 years old and has a specific medical condition, say "Diabetes".

However, due to the parallel processing, you need to ensure that the operations on the stream are thread-safe. You also need to measure the time taken to process the records in parallel and compare it with the time taken to process the records sequentially.

The `optimizeProcessing` method should perform the following operations:

1. Use the Stream API to process the list of `PatientRecord` objects in parallel.
2. Filter the records to include only patients who are at least 18 years old and have "Diabetes" as their medical condition.
3. Ensure that the operations on the stream are thread-safe.
4. Measure the time taken to process the records in parallel.
5. Process the records sequentially and measure the time taken.
6. Compare the time taken for parallel and sequential processing and return the results along with the filtered list of patient records.

Note: You can assume that the age is a string that should be converted to an integer for the comparison, and the medical condition is always a non-null and non-empty string.)
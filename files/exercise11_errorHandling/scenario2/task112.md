## Task 1

**Problem Statement:**

You are given a large DNA sequence file. Each line in the file represents a DNA sequence. Your task is to implement two methods:

1. `readAndValidateSequences(String filePath)`: This method should read the file, validate each DNA sequence, and return a list of valid sequences. A valid DNA sequence only contains the characters 'A', 'C', 'G', and 'T'. If a sequence is invalid, log an error message and continue with the next sequence.
    
2. `writeValidSequencesToFile(List<String> sequences, String filePath)`: This method should write the valid sequences to a new file. If writing to the file fails, log an error message and continue with the next sequence.
    

**Example:**

Input file content:

ACGT

ACGX

ACGT

Output file content:

ACGT

ACGT

## Task 2

**Topic: File Performance**

**Problem Statement:**

You are given a large DNA sequence file. Each line in the file represents a DNA sequence. Your task is to implement two methods:

1. `readSequencesWithBuffer(String filePath)`: This method should read the file using a buffer to improve performance. Return a list of all sequences.
    
2. `writeSequencesWithBuffer(List<String> sequences, String filePath)`: This method should write the sequences to a new file using a buffer to improve performance. If an error occurs during writing, log the error and continue with the next sequence.
    

**Example:**

Input file content:

ACGT

ACGT

ACGT

Output file content:

ACGT

ACGT

ACGT

## Task 3

**Topic: File Handling with Data Structures**

**Problem Statement:**

You are given a large DNA sequence file. Each line in the file represents a DNA sequence. Your task is to implement two methods:

1. `readSequencesToMap(String filePath)`: This method should read the file and store each sequence and its count in a HashMap. If an error occurs during reading, log the error and continue with the next sequence.
    
2. `writeMapToFile(Map<String, Integer> sequenceMap, String filePath)`: This method should write the sequence map to a new file. Each line in the file should contain a sequence and its count separated by a comma. If an error occurs during writing, log the error and continue with the next sequence.
    

**Example:**

Input file content:

ACGT

ACGT

ACGT

Output file content:

ACGT,3

## Task 4

**Topic: File Attributes**

**Problem Statement:**

You are given a large DNA sequence file. Each line in the file represents a DNA sequence. Your task is to implement three methods:

1. `readSequencesAndAttributes(String filePath)`: This method should read the file and return a list of all sequences. Additionally, it should return the file's size and last modified time.
    
2. `writeSequencesAndAttributes(List<String> sequences, String filePath)`: This method should write the sequences to a new file. Additionally, it should set the file's last modified time to the current time.
    
3. `getFileAttributes(String filePath)`: This method should return the file's size and last modified time.
    

**Example:**

Input file content:

ACGT

ACGT

ACGT

Output file content:

ACGT

ACGT

ACGT
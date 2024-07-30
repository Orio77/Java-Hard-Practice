Task 1: Buffered Campaign Data Analyzer

Background: As part of the digital marketing agency's campaign management tool, you are tasked to create a `BufferedCampaignDataAnalyzer` class that will handle the reading and analysis of campaign data from a file. The data file will contain campaign metrics from various digital platforms. Each line in the file represents a campaign and contains comma-separated values: `CampaignID,Platform,Metric1,Metric2,Metric3`.

Functionality 1: `readCampaignData(String filePath)`

- This method should take a file path as input.
- It should use a BufferedReader to read the file line by line.
- Each line should be split into an array of Strings.
- The method should return a List of Campaign objects. Each Campaign object should contain the CampaignID, Platform, and Metrics.

Functionality 2: `analyzeCampaignData(List<Campaign> campaigns)`

- This method should take a List of Campaign objects as input.
- It should calculate the average of each metric for each platform.
- The method should return a Map where the key is the platform and the value is an array of average metrics.

Example Input:

readCampaignData("campaigns.txt")

Example Output:

analyzeCampaignData(campaigns)

Returns:

{

  "Facebook": [3.5, 4.2, 5.1],

  "Google": [4.1, 3.9, 4.7]

}

---

Task 2: Buffered File Permissions Checker

Background: The digital marketing agency needs to ensure that the campaign data files have the correct permissions. You are tasked to create a `BufferedFilePermissionsChecker` class that will check the permissions of a file.

Functionality 1: `checkReadPermission(String filePath)`

- This method should take a file path as input.
- It should use the Files class to check if the file has read permission.
- The method should return a boolean indicating whether the file has read permission.

Functionality 2: `checkWritePermission(String filePath)`

- This method should take a file path as input.
- It should use the Files class to check if the file has write permission.
- The method should return a boolean indicating whether the file has write permission.

Example Input:

checkReadPermission("campaigns.txt")

checkWritePermission("campaigns.txt")

Example Output:

true

false

---

Task 3: Buffered File Attributes Reader

Background: The digital marketing agency needs to retrieve the attributes of the campaign data files. You are tasked to create a `BufferedFileAttributesReader` class that will read the attributes of a file.

Functionality 1: `readFileSize(String filePath)`

- This method should take a file path as input.
- It should use the Files class to read the size of the file.
- The method should return the size of the file in bytes.

Functionality 2: `readFileCreationTime(String filePath)`

- This method should take a file path as input.
- It should use the Files class to read the creation time of the file.
- The method should return the creation time of the file.

Example Input:

readFileSize("campaigns.txt")

readFileCreationTime("campaigns.txt")

Example Output:

1024

2022-01-01T00:00:00Z

---

Task 4: Buffered File Performance Optimizer

Background: The digital marketing agency needs to optimize the performance of reading and writing to the campaign data files. You are tasked to create a `BufferedFilePerformanceOptimizer` class that will optimize file operations.

Functionality 1: `optimizeReadPerformance(String filePath)`

- This method should take a file path as input.
- It should use a BufferedInputStream to read the file.
- The method should return the time taken to read the file in milliseconds.

Functionality 2: `optimizeWritePerformance(String filePath, List<String> data)`

- This method should take a file path and a List of Strings as input.
- It should use a BufferedOutputStream to write the data to the file.
- The method should return the time taken to write to the file in milliseconds.

Functionality 3: `comparePerformance(String filePath, List<String> data)`

- This method should take a file path and a List of Strings as input.
- It should call the `optimizeReadPerformance` and `optimizeWritePerformance` methods and compare the times.
- The method should return a String indicating which operation was faster.

Example Input:

optimizeReadPerformance("campaigns.txt")

optimizeWritePerformance("campaigns.txt", data)

comparePerformance("campaigns.txt", data)

Example Output:

100

200

"Reading was faster than writing"
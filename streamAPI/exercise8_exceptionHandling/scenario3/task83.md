Task 1

Problem: Given a list of environmental data records, each record contains the date (in the format of "yyyy-MM-dd"), the location, and the temperature. Your task is to implement two methods:

1. `filterAndSortRecords(List<String> records)`: This method should filter out records that have temperatures below 0 degrees Celsius, handle any parsing exceptions that may occur due to incorrect date format, and then sort the remaining records in ascending order of date.
    
2. `calculateAverageTemperature(List<String> records)`: This method should calculate the average temperature of all records, handle any number format exceptions that may occur due to incorrect temperature values, and return the average temperature.
    

Example Input:

[

  "2022-01-01,New York,-5",

  "2022-02-01,Los Angeles,20",

  "2022-01-15,New York,abc",

  "2022-01-10,Los Angeles,15"

]

Example Output for `filterAndSortRecords`:

[

  "2022-01-10,Los Angeles,15",

  "2022-02-01,Los Angeles,20"

]

Example Output for `calculateAverageTemperature`: `17.5`

Task 2

Topic: Stream Performance

Problem: Given a list of environmental data records, each record contains the date (in the format of "yyyy-MM-dd"), the location, and the temperature. Your task is to implement two methods:

1. `findMaxTemperature(List<String> records)`: This method should find the record with the maximum temperature, handle any number format exceptions that may occur due to incorrect temperature values, and return the record. Use parallel streams to improve performance.
    
2. `findMinTemperature(List<String> records)`: This method should find the record with the minimum temperature, handle any number format exceptions that may occur due to incorrect temperature values, and return the record. Use parallel streams to improve performance.
    

Example Input:

[

  "2022-01-01,New York,-5",

  "2022-02-01,Los Angeles,20",

  "2022-01-15,New York,abc",

  "2022-01-10,Los Angeles,15"

]

Example Output for `findMaxTemperature`: `"2022-02-01,Los Angeles,20"` Example Output for `findMinTemperature`: `"2022-01-01,New York,-5"`

Task 3

Topic: Stream API with Data Structures

Problem: Given a list of environmental data records, each record contains the date (in the format of "yyyy-MM-dd"), the location, and the temperature. Your task is to implement two methods:

1. `groupByLocation(List<String> records)`: This method should group records by location, handle any parsing exceptions that may occur due to incorrect date format, and return a map where the key is the location and the value is a list of records.
    
2. `calculateAverageTemperatureByLocation(List<String> records)`: This method should calculate the average temperature for each location, handle any number format exceptions that may occur due to incorrect temperature values, and return a map where the key is the location and the value is the average temperature.
    

Example Input:

[

  "2022-01-01,New York,-5",

  "2022-02-01,Los Angeles,20",

  "2022-01-15,New York,abc",

  "2022-01-10,Los Angeles,15"

]

Example Output for `groupByLocation`:

{

  "New York": ["2022-01-01,New York,-5", "2022-01-15,New York,abc"],

  "Los Angeles": ["2022-02-01,Los Angeles,20", "2022-01-10,Los Angeles,15"]

}

Example Output for `calculateAverageTemperatureByLocation`: `{"New York": -5, "Los Angeles": 17.5}`

Task 4

Topic: Stream Ordering

Problem: Given a list of environmental data records, each record contains the date (in the format of "yyyy-MM-dd"), the location, and the temperature. Your task is to implement three methods:

1. `sortRecordsByDate(List<String> records)`: This method should sort the records in ascending order of date, handle any parsing exceptions that may occur due to incorrect date format, and return the sorted records.
    
2. `sortRecordsByTemperature(List<String> records)`: This method should sort the records in ascending order of temperature, handle any number format exceptions that may occur due to incorrect temperature values, and return the sorted records.
    
3. `sortRecordsByLocation(List<String> records)`: This method should sort the records in ascending order of location, handle any parsing exceptions that may occur due to incorrect date format, and return the sorted records.
    

Example Input:

[

  "2022-01-01,New York,-5",

  "2022-02-01,Los Angeles,20",

  "2022-01-15,New York,abc",

  "2022-01-10,Los Angeles,15"

]

Example Output for `sortRecordsByDate`:

[

  "2022-01-01,New York,-5",

  "2022-01-10,Los Angeles,15",

  "2022-01-15,New York,abc",

  "2022-02-01,Los Angeles,20"

]

Example Output for `sortRecordsByTemperature`: `["2022-01-01,New York,-5", "2022-01-10,Los Angeles,15", "2022-02-01,Los Angeles,20"]` Example Output for `sortRecordsByLocation`: `["2022-02-01,Los Angeles,20", "2022-01-10,Los Angeles,15", "2022-01-01,New York,-5", "2022-01-15,New York,abc"]`
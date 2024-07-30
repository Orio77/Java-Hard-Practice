Task 1

You are given a list of `MeterReading` objects. Each `MeterReading` object has `meterId`, `timestamp` and `reading` fields.

1. Implement a method `getAverageReadingPerMeter(List<MeterReading> readings)` that calculates the average energy reading per meter. The method should return a `Map<String, Double>` where the key is the `meterId` and the value is the average reading for that meter. Use method references where possible.
    
2. Implement a method `getPeakReadingTimes(List<MeterReading> readings)` that finds the time of day (hour) with the highest average energy reading. The method should return a `Map<Integer, Double>` where the key is the hour of the day (0-23) and the value is the average reading for that hour. Use method references where possible.
    

Example:

Input:

List<MeterReading> readings = Arrays.asList(

    new MeterReading("meter1", LocalDateTime.of(2022, 1, 1, 10, 0), 100.0),

    new MeterReading("meter1", LocalDateTime.of(2022, 1, 1, 11, 0), 200.0),

    new MeterReading("meter2", LocalDateTime.of(2022, 1, 1, 10, 0), 300.0),

    new MeterReading("meter2", LocalDateTime.of(2022, 1, 1, 11, 0), 400.0)

);

Output:

getAverageReadingPerMeter(readings) => {"meter1": 150.0, "meter2": 350.0}

getPeakReadingTimes(readings) => {10: 200.0, 11: 300.0}

Task 2

Main Topic: Method References with Stream API Drawn Topic: Stream Performance

1. Implement a method `getFastestGrowingMeters(List<MeterReading> readings)` that finds the meters with the highest increase in readings over time. The method should return a `List<String>` of `meterId`s. Use method references and ensure the stream operations are as performant as possible.
    
2. Implement a method `getMostConsistentMeters(List<MeterReading> readings)` that finds the meters with the least variation in readings over time. The method should return a `List<String>` of `meterId`s. Use method references and ensure the stream operations are as performant as possible.
    

Task 3

Main Topic: Method References with Stream API Drawn Topic: Exception Handling

1. Implement a method `getReadingsWithErrors(List<MeterReading> readings)` that finds any readings that could not be processed due to errors. The method should return a `List<MeterReading>` of the problematic readings. Use method references and handle exceptions gracefully.
    
2. Implement a method `getReadingsWithoutErrors(List<MeterReading> readings)` that finds any readings that were processed successfully. The method should return a `List<MeterReading>` of the successful readings. Use method references and handle exceptions gracefully.
    

Task 4

Main Topic: Method References with Stream API Drawn Topic: Stream API with Data Structures

1. Implement a method `getMeterReadingFrequency(List<MeterReading> readings)` that calculates how frequently each meter has readings. The method should return a `Map<String, Long>` where the key is the `meterId` and the value is the count of readings for that meter. Use method references and work with data structures effectively.
    
2. Implement a method `getPeakReadingDays(List<MeterReading> readings)` that finds the days with the highest average energy reading. The method should return a `Map<LocalDate, Double>` where the key is the date and the value is the average reading for that day. Use method references and work with data structures effectively.
    
3. Implement a method `getReadingTrends(List<MeterReading> readings)` that calculates the trend of readings over time for each meter. The method should return a `Map<String, List<Double>>` where the key is the `meterId` and the value is a list of average readings for each day, in chronological order. Use method references and work with data structures effectively.
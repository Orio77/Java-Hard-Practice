## Task 1

You are to implement two methods, `processProductionRecord` and `generateInventoryReport`.

The `processProductionRecord` method should:

1. Accept a file path as input. This file contains production records, each line representing a single record.
2. Read the file line by line.
3. Parse each line into a ProductionRecord object (you'll need to create this class), which should include fields for product name, quantity produced, and production date.
4. Store each ProductionRecord object in a list.
5. Return the list of ProductionRecord objects.

The `generateInventoryReport` method should:

1. Accept a list of ProductionRecord objects as input.
2. Calculate the total quantity produced for each product.
3. Write these totals to a new file, with each line in the format: "Product: [product name], Quantity: [quantity]".
4. Handle any IO exceptions that may occur, logging an error message and terminating the program gracefully.

Example Input:

processProductionRecord("production_records.txt")

Example Output:

generateInventoryReport(productionRecordsList)

The output file should look something like this:

Product: Widget A, Quantity: 1200

Product: Widget B, Quantity: 900

## Task 2

For this task, we'll focus on "File Permissions". Implement two methods, `secureFile` and `checkFileSecurity`.

The `secureFile` method should:

1. Accept a file path as input.
2. Change the file permissions to only allow the owner read and write access.
3. Return a boolean indicating whether the operation was successful.

The `checkFileSecurity` method should:

1. Accept a file path as input.
2. Check the file's permissions.
3. Return a boolean indicating whether only the owner has read and write access.

Example Input:

secureFile("production_records.txt")

checkFileSecurity("production_records.txt")

Example Output:

true

true

## Task 3

This task will focus on "File Handling with Data Structures". Implement two methods, `readRecordsIntoMap` and `writeMapToNewFile`.

The `readRecordsIntoMap` method should:

1. Accept a file path as input. This file contains production records, each line representing a single record.
2. Read the file line by line.
3. Parse each line into a key-value pair, where the key is the product name and the value is the quantity produced.
4. Store each key-value pair in a Map.
5. Return the Map.

The `writeMapToNewFile` method should:

1. Accept a Map and a file path as input.
2. Write the Map's contents to the new file, with each line in the format: "Product: [product name], Quantity: [quantity]".
3. Handle any IO exceptions that may occur, logging an error message and terminating the program gracefully.

Example Input:

readRecordsIntoMap("production_records.txt")

writeMapToNewFile(productionMap, "new_records.txt")

Example Output:

The output file should look something like this:

Product: Widget A, Quantity: 1200

Product: Widget B, Quantity: 900

## Task 4

This task will focus on "Performance Optimization". Implement three methods, `readLargeFile`, `processRecords`, and `writeLargeFile`.

The `readLargeFile` method should:

1. Accept a file path as input. This file contains a large number of production records.
2. Read the file line by line, but in a way that minimizes memory usage.
3. Parse each line into a ProductionRecord object.
4. Store each ProductionRecord object in a list.
5. Return the list of ProductionRecord objects.

The `processRecords` method should:

1. Accept a list of ProductionRecord objects as input.
2. Calculate the total quantity produced for each product.
3. Store these totals in a Map.
4. Return the Map.

The `writeLargeFile` method should:

1. Accept a Map and a file path as input.
2. Write the Map's contents to the new file, but in a way that minimizes memory usage.
3. Each line should be in the format: "Product: [product name], Quantity: [quantity]".
4. Handle any IO exceptions that may occur, logging an error message and terminating the program gracefully.

Example Input:

readLargeFile("large_production_records.txt")

processRecords(productionRecordsList)

writeLargeFile(productionMap, "large_output.txt")

Example Output:

The output file should look something like this:

Product: Widget A, Quantity: 120000

Product: Widget B, Quantity: 90000
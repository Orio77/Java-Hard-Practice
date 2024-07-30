Task 1:

Problem: Implement a system for managing event details. The system should be able to read event details from a file, modify them, and write the updated details back to the file.

Function 1: `readEventDetails(filePath: String) -> Event`

- Open the file at the given file path.
- Read the event details from the file. The details are in JSON format and represent an `Event` object.
- Parse the JSON into an `Event` object.
- Close the file and return the `Event` object.

Function 2: `writeEventDetails(filePath: String, event: Event)`

- Open the file at the given file path.
- Convert the `Event` object into JSON.
- Write the JSON to the file.
- Close the file.

Example Input: filePath = "eventDetails.json" event = Event("Wedding", "12/12/2022", ["John Doe", "Jane Doe"], ["Catering", "Photography"])

Example Output: The file "eventDetails.json" should be updated with the details of the event.

---

Task 2:

Topic: File Permissions

Problem: Implement a system for managing file permissions for event details. The system should be able to check if a file is readable and writable, and if not, change the permissions to make it so.

Function 1: `checkPermissions(filePath: String) -> Boolean`

- Get the file permissions of the file at the given file path.
- Check if the file is readable and writable.
- Return true if the file is readable and writable, false otherwise.

Function 2: `changePermissions(filePath: String)`

- Get the file permissions of the file at the given file path.
- Change the permissions to make the file readable and writable.
- Save the updated permissions.

Example Input: filePath = "eventDetails.json"

Example Output: The file "eventDetails.json" should be readable and writable.

---

Task 3:

Topic: File Handling with Data Structures

Problem: Implement a system for managing guest lists for events. The system should be able to read a guest list from a file, add a guest to the list, and write the updated list back to the file.

Function 1: `readGuestList(filePath: String) -> List<String>`

- Open the file at the given file path.
- Read the guest list from the file. The list is in JSON format and represents a list of guest names.
- Parse the JSON into a list of strings.
- Close the file and return the list.

Function 2: `addGuest(filePath: String, guest: String)`

- Call `readGuestList` to get the current guest list.
- Add the new guest to the list.
- Convert the updated list into JSON.
- Open the file at the given file path.
- Write the JSON to the file.
- Close the file.

Example Input: filePath = "guestList.json" guest = "John Doe"

Example Output: The file "guestList.json" should be updated with the updated guest list.

---

Task 4:

Topic: Error Handling Strategies

Problem: Implement a system for managing vendor contracts for events. The system should be able to read a contract from a file, modify it, and write the updated contract back to the file. If any errors occur during these operations, the system should handle them gracefully and log the error details to a separate file.

Function 1: `readContract(filePath: String) -> Contract`

- Try to open the file at the given file path.
- If the file does not exist, catch the error, log it to a file, and return null.
- Try to read the contract details from the file. The details are in JSON format and represent a `Contract` object.
- If the JSON is malformed, catch the error, log it to a file, and return null.
- Parse the JSON into a `Contract` object.
- Close the file and return the `Contract` object.

Function 2: `writeContract(filePath: String, contract: Contract)`

- Try to open the file at the given file path.
- If the file does not exist, catch the error, log it to a file, and return.
- Convert the `Contract` object into JSON.
- Try to write the JSON to the file.
- If the write operation fails, catch the error, log it to a file, and return.
- Close the file.

Function 3: `logError(errorFilePath: String, error: Exception)`

- Open the file at the given error file path.
- Write the details of the error to the file.
- Close the file.

Example Input: filePath = "contract.json" errorFilePath = "errorLog.txt" contract = Contract("Catering", "12/12/2022", "12/13/2022", 1000)

Example Output: The file "contract.json" should be updated with the details of the contract. If any errors occurred, the details should be logged to "errorLog.txt".
**Scenario 1: Developing a Student Management System**

**Enhanced Task 1**: Create a `Student` class with attributes like name, ID, and courses enrolled. The class should have methods to get and set these attributes. The `Student` class should also have a method to display all the information about a student.

_Potential Input_:

student = Student("John Doe", 123, ["Math", "Science"])

student.set_name("Jane Doe")

student.get_name()

student.display_info()

_Desired Output_:

"Jane Doe"

"Student Name: Jane Doe, ID: 123, Courses: ['Math', 'Science']"

_Coach Suggestions_: Start by defining the `Student` class with the `__init__` method to initialize the attributes. Then, implement the getter and setter methods. Finally, create a method to display the student information.

**Enhanced Task 2**: Implement methods for adding and removing students from the system. The system should be represented by a `School` class that contains a list of `Student` objects. The `School` class should have methods to add a `Student` object to the list and remove a `Student` object from the list by ID.

_Potential Input_:

school = School()

school.add_student(student)

school.remove_student(123)

_Desired Output_:

"Student added."

"Student removed."

_Coach Suggestions_: Define the `School` class with an attribute that is a list of `Student` objects. Then, implement the methods to add and remove students. Remember to handle the case where a student with the given ID does not exist.

**Enhanced Task 3**: Develop a user interface for administrators to interact with the system. The interface should allow administrators to create new `Student` objects, add them to the `School`, and remove them from the `School`.

_Potential Input_:

interface = Interface(school)

interface.create_student("John Doe", 123, ["Math", "Science"])

interface.add_student(123)

interface.remove_student(123)

_Desired Output_:

"Student created."

"Student added."

"Student removed."

_Coach Suggestions_: Create an `Interface` class that takes a `School` object as an argument. The `Interface` class should have methods that call the corresponding methods of the `School` object. Make sure to handle any errors that may occur.

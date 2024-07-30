**Scenario: Building a Shape Hierarchy for Drawing**

**Enhanced Task 1**: Design a base `Shape` class with abstract methods for calculating area and perimeter. This class should also have a `draw` method that prints a message to the console.

_Potential Input_:

Shape shape = new Circle(5);

shape.draw();|

_Desired Output_:

"Drawing a shape."

_Coach Suggestions_: Start by defining the `Shape` class and make it abstract. Then, declare the abstract methods for calculating area and perimeter. Also, implement a `draw` method that prints a generic message.

**Enhanced Task 2**: Implement derived classes like `Circle` and `Rectangle` that extend the `Shape` class. These classes should override the area and perimeter methods with specialized calculations. They should also override the `draw` method to print a specific message.

_Potential Input_:

Shape circle = new Circle(5);

circle.draw();

System.out.println("Area: " + circle.calculateArea());

System.out.println("Perimeter: " + circle.calculatePerimeter());

Shape rectangle = new Rectangle(5, 10);

rectangle.draw();

System.out.println("Area: " + rectangle.calculateArea());

System.out.println("Perimeter: " + rectangle.calculatePerimeter());

_Desired Output_:

"Drawing a circle."

"Area: 78.53981633974483"

"Perimeter: 31.41592653589793"

"Drawing a rectangle."

"Area: 50.0"

"Perimeter: 30.0"

_Coach Suggestions_: Define the `Circle` and `Rectangle` classes that extend the `Shape` class. Then, override the abstract methods with the specific calculations for each shape. Also, override the `draw` method to print a specific message for each shape.

**Enhanced Task 3**: Demonstrate polymorphic behavior by creating a `Drawing` class that contains a list of `Shape` objects. The `Drawing` class should have a method to add a `Shape` to the list and a method to draw all the shapes in the list.

_Potential Input_:

Drawing drawing = new Drawing();

drawing.addShape(circle);

drawing.addShape(rectangle);

drawing.drawAll();

_Desired Output_:

"Drawing a circle."

"Drawing a rectangle."

_Coach Suggestions_: Create a `Drawing` class with a list of `Shape` objects. Then, implement a method to add a `Shape` to the list. Also, implement a method that iterates over the list and calls the `draw` method of each `Shape`. This will demonstrate polymorphic behavior as the specific `draw` method of each `Shape` will be called.

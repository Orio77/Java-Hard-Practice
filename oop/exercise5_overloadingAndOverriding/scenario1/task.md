1. Build a base `Shape` class with methods for drawing and resizing.

   - Your `Shape` class should have methods `draw()` and `resize()`. The `draw()` method should print a generic message like "Drawing a shape". The `resize()` method should take a percentage as a parameter and print a message like "Resizing the shape by {percentage}%".
   - _Potential input_: `Shape shape = new Shape(); shape.draw(); shape.resize(50);`
   - _Desired Output_: "Drawing a shape", "Resizing the shape by 50%"
   - _Coach Suggestions_: Start by defining the `Shape` class and its methods. Make sure the `resize()` method takes a parameter and uses it in its output message.

2. Create subclasses with overloaded methods for custom rendering.

   - Create subclasses like `Circle`, `Rectangle`, etc., each with overloaded `draw()` methods. For example, `Circle` could have `draw()` and `draw(String color)` methods.
   - _Potential input_: `Circle circle = new Circle(); circle.draw(); circle.draw("red");`
   - _Desired Output_: "Drawing a circle", "Drawing a red circle"
   - _Coach Suggestions_: Define each subclass and its `draw()` methods. The overloaded `draw(String color)` method should print a message that includes the color.

3. Allow for method overriding to enable specialized rendering in derived classes.

   - Override the `resize()` method in each subclass to print a message specific to that shape. For example, `Circle`'s `resize()` method could print "Resizing the circle by {percentage}%".
   - _Potential input_: `circle.resize(50);`
   - _Desired Output_: "Resizing the circle by 50%"
   - _Coach Suggestions_: In each subclass, override the `resize()` method to include the shape's name in the output message. Make sure to use the `@Override` annotation to indicate that the method is intended to override a method in the superclass.

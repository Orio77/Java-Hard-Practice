**Scenario X: Developing an Advanced Vehicle Rental System**

**Task 1: Define a base `Vehicle` class with attributes common to all vehicles.**

Enhanced Task: Define a base `Vehicle` class with attributes common to all vehicles such as `id`, `model`, `year`, and `rental_price_per_day`. Implement methods that will be overridden in subclasses, such as `calculate_rental_price(days)`. This method should return the base rental price for the given number of days.

_Potential Input_: No input is required for this task.

_Desired Output_: A `Vehicle` class with common attributes and a method to calculate the rental price.

_Coach Suggestions_: Start by defining the `Vehicle` class and its `__init__` method. Then, implement the `calculate_rental_price` method. Remember, this method will be overridden in subclasses, so it should be implemented in a way that allows for polymorphism.

**Task 2: Create subclasses for specific vehicle types (e.g., car, bike, truck) with unique features.**

Enhanced Task: Create subclasses for `Car`, `Bike`, and `Truck` that inherit from the `Vehicle` class. Each subclass should have unique attributes and override the `calculate_rental_price` method to include these unique features in the calculation. For example, a `Car` might have a `luxury_tax` attribute that increases the rental price.

_Potential Input_: No input is required for this task.

_Desired Output_: Subclasses `Car`, `Bike`, and `Truck` with unique attributes and overridden `calculate_rental_price` methods.

_Coach Suggestions_: Start by defining the subclasses and their unique attributes. Then, override the `calculate_rental_price` method in each subclass to include the unique attributes in the calculation. Remember to use the `super()` function to access the parent class's methods.

**Task 3: Ensure that the rental system can handle different vehicle types seamlessly.**

Enhanced Task: Implement a `RentalSystem` class that can handle different vehicle types. This class should have a method `rent_vehicle(vehicle, days)` that takes a `Vehicle` object and the number of days as input, and returns the rental price by calling the `calculate_rental_price` method on the `Vehicle` object.

_Potential Input_: A `Vehicle` object and the number of days for the rental.

_Desired Output_: The rental price for the given `Vehicle` object and number of days.

_Coach Suggestions_: Define the `RentalSystem` class and its `rent_vehicle` method. This method should take a `Vehicle` object and the number of days as input, and return the rental price by calling the `calculate_rental_price` method on the `Vehicle` object. This will demonstrate polymorphism, as the correct `calculate_rental_price` method will be called depending on the type of the `Vehicle` object.
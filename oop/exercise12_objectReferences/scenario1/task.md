**Scenario 1**: "Building a Customer Relationship Management (CRM) System"

- **Task 1**: Create a `Customer` class with references to related entities like contacts and orders.
    
    - **Enhanced Task**: Create a `Customer` class with fields for `name`, `email`, and a `List` of `Order` and `Contact` objects. These lists represent the relationships between a customer and their orders and contacts. The `Order` and `Contact` classes should also have a reference back to the `Customer` object to maintain the bidirectional relationship.
    - _Potential input_: `Customer("John Doe", "john.doe@example.com")`
    - _Desired Output_: A `Customer` object with the given name and email, and empty lists for orders and contacts.
    - _Coach Suggestions_: Start by defining the `Customer`, `Order`, and `Contact` classes. Use `ArrayList` for the lists of orders and contacts. Remember to include methods to add orders and contacts to a customer, and to set the customer in the `Order` and `Contact` objects.
- **Task 2**: Implement methods to manage customer relationships and associated data.
    
    - **Enhanced Task**: Implement methods in the `Customer` class to add an `Order` or a `Contact`, and to get all orders or contacts for a customer. In the `Order` and `Contact` classes, implement methods to set and get the `Customer`.
    - _Potential input_: `customer.addOrder(new Order(...)); customer.addContact(new Contact(...));`
    - _Desired Output_: The added order and contact should appear in the lists of orders and contacts for the customer, and the `getCustomer()` method in the `Order` and `Contact` objects should return the correct `Customer`.
    - _Coach Suggestions_: Remember to set the `Customer` in the `Order` and `Contact` objects when they are added to a `Customer`. This maintains the bidirectional relationship.
- **Task 3**: Ensure that references between entities are maintained correctly.
    
    - **Enhanced Task**: Implement checks in the `addOrder`, `addContact`, `setCustomer` methods to ensure that the relationships are maintained correctly. For example, when an order is added to a customer, the customer should also be set in the order.
    - _Potential input_: `customer.addOrder(order);`
    - _Desired Output_: `order.getCustomer()` should return the correct `Customer`.
    - _Coach Suggestions_: You can add these checks in the `addOrder`, `addContact`, `setCustomer` methods. For example, in the `addOrder` method, after adding the order to the list, you can check if the customer in the order is correct, and if not, set it.
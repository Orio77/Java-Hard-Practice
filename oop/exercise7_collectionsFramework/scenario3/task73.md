**Advanced Collection Management System**

- **Task 1**: Create a class `CollectionManager` with methods for `add(Object item)`, `remove(Object item)`, `find(Object item)`, and `clear()`. Each method should perform the corresponding operation on a collection.
    
    - `add(Object item)`: This method should add the specified item to the collection.
    - `remove(Object item)`: This method should remove the specified item from the collection.
    - `find(Object item)`: This method should find the specified item in the collection and return its index.
    - `clear()`: This method should remove all items from the collection.
- **Task 2**: Implement a method `manageCollection(CollectionDetail collectionDetail)` that performs the specified operation (`add`, `remove`, `find`, or `clear`) on the collection based on the provided `CollectionDetail`.
    
    - In `manageCollection(CollectionDetail collectionDetail)`, determine the operation to perform based on the `operation` attribute of the `CollectionDetail` object. Perform the appropriate operation using the `CollectionManager` methods.
- **Task 3**: Design a class `AdvancedCollectionManager` that extends `CollectionManager` and overrides the `add(Object item)`, `remove(Object item)`, `find(Object item)`, and `clear()` methods. The overridden methods should include additional logic, such as validation checks and support for more complex operations.
    
    - `add(Object item)`: Overridden method that adds the specified item to the collection only if it is not already present.
    - `remove(Object item)`: Overridden method that removes the specified item from the collection only if it is present.
    - `find(Object item)`: Overridden method that finds the specified item in the collection and returns a list of all its indices.
    - `clear()`: Overridden method that removes all items from the collection and returns the number of items removed.

**Further practise**:

1. **Advanced Collection Management – Enhanced Details**:
    
    - Implement `isEligibleForAddition(Object item)` to check if the item is eligible for addition to the collection based on its details (e.g., type, value).
2. **Tier-Based Collection Operation Logic – Enhanced Details**:
    
    - Implement different operation logic for different tiers of collections. For example, small collections may support all operations, while large collections may only support addition and removal operations.
3. **Customizable Collection Operation Policy – Enhanced Details**:
    
    - **Functionality Description**: Integrate the Strategy pattern into the collection operation logic. Define a `CollectionOperationStrategy` interface with a method `performOperation(Collection collection, String operation)`.
    - **SmallCollectionOperation**: Implement this strategy to perform operations on small collections. This strategy should be used when the collection is small.
    - **LargeCollectionOperation**: Implement this strategy to perform operations on large collections. This strategy should be used when the collection is large.
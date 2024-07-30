## Classes to Create

1. `PaymentGateway`
2. `Payment`
3. `SecurePayment`
4. `PaymentProcessor`

## Class Methods to Implement

### `PaymentGateway`

This class acts as the base class for different payment gateways.

### `Payment`

This class represents a generic payment. It should contain necessary information about a payment such as amount, currency, payer, and receiver.

### `SecurePayment`

This class extends the `Payment` class. It represents a secure payment and should contain additional security-related information.

### `PaymentProcessor`

This class is responsible for processing payments. It should contain the following methods:

- `processPayment`: This method should take a payment gateway and a payment as parameters. It should process the payment through the provided payment gateway.
    
- `secureProcess`: This method should take a payment gateway and a secure payment as parameters. It should process the secure payment through the provided payment gateway.
    
- `isCompatible`: This method should take a payment gateway as a parameter. It should check if the provided payment gateway is compatible with the processor.
    

## General Overview

The `PaymentProcessor` class is the main class in this exercise. It uses Java Generics with bounded type parameters to ensure compatibility with specific payment gateways and type safety. The `PaymentGateway` class is the base class for different payment gateways. The `Payment` and `SecurePayment` classes represent different types of payments.

The `PaymentProcessor` class has methods to process both generic and secure payments. It uses the generic type `T` in method parameters, allowing for flexibility in processing payments through different gateways. The `isCompatible` method checks if the provided payment gateway is of a type that extends `PaymentGateway`, thus ensuring compatibility and type safety.

## Example Workflow

1. Create a `PaymentGateway` object.
2. Create a `Payment` or `SecurePayment` object with necessary information.
3. Create a `PaymentProcessor` object.
4. Call the `processPayment` or `secureProcess` method of the `PaymentProcessor` object with the `PaymentGateway` and `Payment` or `SecurePayment` objects as parameters.
5. The `PaymentProcessor` processes the payment through the provided payment gateway.
6. Call the `isCompatible` method of the `PaymentProcessor` object with the `PaymentGateway` object as a parameter.
7. The `isCompatible` method checks if the provided payment gateway is compatible with the processor.
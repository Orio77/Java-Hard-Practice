# Scenario 2: Banking Transaction Tracker

## Enhanced Sprint Tasks:

### Task 1: Define a BankAccount class with private balance and transaction history.

- Implement encapsulation by making the balance and transaction history private. Provide public getter and setter methods to access and modify these private variables, ensuring that the balance cannot be set directly and can only be modified through deposit and withdrawal methods.
- Add a private variable for account number and make it read-only, i.e., it can only be set in the constructor and not modified afterwards.
- Add a private variable for account password and provide a public method to change the password, ensuring the new password meets certain criteria (e.g., minimum length, contains numbers and special characters, etc.).

### Task 2: Implement methods to deposit, withdraw, and view transaction history.

- Implement a method to deposit money into the account. This method should update the balance and add a record to the transaction history.
- Implement a method to withdraw money from the account. This method should check if the account has sufficient balance before making the withdrawal, update the balance, and add a record to the transaction history.
- Implement a method to view the transaction history. This method should return a read-only view of the transaction history to prevent any modifications.

### Task 3: Use access modifiers to restrict unauthorized access to account data.

- Use access modifiers to ensure that only the account owner can deposit, withdraw, or view transaction history.
- Implement a method to verify the account password before allowing access to sensitive methods like withdrawal and viewing transaction history.
- Use access modifiers to ensure that the account number and password cannot be accessed directly and can only be modified through their respective methods.
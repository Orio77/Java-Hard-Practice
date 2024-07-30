### Project Overview: Library Management System

#### Stage 1: Basic Library System Structure (SRP and Encapsulation)

- **Problem:** Design a basic Library Management System with classes like `Book`, `Member`, `Librarian`, and `Loan`. Each class should have responsibilities clearly defined, adhering to the Single Responsibility Principle. Ensure all properties are properly encapsulated.
- **Focus:** Establishing a solid foundation with SRP and encapsulation.

#### Stage 2: Adding Features with Open/Closed Principle (OCP)

- **Problem:** Extend the Library Management System to handle different types of loans (like short-term, long-term) and various member categories (like students, faculty) without modifying existing classes, adhering to the OCP.
- **Focus:** Using patterns like Strategy or Template Method for extensibility.

#### Stage 3: Polymorphism and Liskov Substitution Principle (LSP)

- **Problem:** Introduce a reporting feature to generate reports (like overdue loans, frequent members). Reports should be generated in multiple formats (PDF, HTML). Ensure that subclasses of `Report` can be substituted without affecting the functionality.
- **Focus:** Effective use of polymorphism and adhering to LSP.

#### Stage 4: Interface Segregation Principle (ISP)

- **Problem:** The system has a monolithic interface `LibraryOperations` used by `Librarian`. Refactor this interface into smaller, specific interfaces (like `LoanOperations`, `MemberManagement`) to ensure that `Librarian` only uses methods relevant to its operation.
- **Focus:** Breaking down a large interface into smaller, more relevant ones.

#### Stage 5: Dependency Inversion Principle (DIP) in System Integration

- **Problem:** Integrate an external notification system (for overdue books, reservation alerts) into the Library Management System. Use DIP to reduce coupling between the library system and the notification system.
- **Focus:** Applying DIP through dependency injection and abstraction.

#### Stage 6: Implementing Composition Over Inheritance

- **Problem:** The Library Management System's class hierarchy for member types and loan types is becoming too complex. Refactor the system to use composition over inheritance where it makes sense.
- **Focus:** Simplifying the system using composition.

#### Stage 7: Custom Collector for Data Analysis

- **Problem:** Implement a custom Stream Collector in the reporting module to gather complex statistics about library usage (e.g., most popular books, average loan time).
- **Focus:** Advanced usage of Java Streams and custom collectors.

#### Stage 8: Advanced Features and Real-World Simulation

- **Problem:** Add advanced features like reservation systems, late fee calculations, and user authentication. Simulate real-world library operations to test the system.
- **Focus:** Integrating advanced features and real-world testing.

### Stage 1: Basic Library System Structure (SRP and Encapsulation)

- **Classes & Methods:**
    - `Book`: `getTitle()`, `getAuthor()`, `getISBN()`, `setLoanStatus()`.
    - `Member`: `getId()`, `getName()`, `getLoans()`.
    - `Librarian`: `checkOutBook(Book book, Member member)`, `returnBook(Book book)`.
    - `Loan`: `getLoanDetails()`, `isOverdue()`.

### Stage 2: Adding Features with Open/Closed Principle (OCP)

- **Classes & Methods:**
    - `LoanType`: An interface with `calculateDueDate()`.
    - `ShortTermLoan`, `LongTermLoan`: Implement `LoanType`.
    - `MemberCategory`: An interface with `calculateMaxBooks()`.
    - `Student`, `Faculty`: Implement `MemberCategory`.

### Stage 3: Polymorphism and Liskov Substitution Principle (LSP)

- **Classes & Methods:**
    - `Report`: An abstract class with `generateReport()`.
    - `OverdueLoanReport`, `FrequentMemberReport`: Extend `Report`, implement `generateReport()`.
    - `ReportGenerator`: `generateReport(Report report)`.

### Stage 4: Interface Segregation Principle (ISP)

- **Classes & Methods:**
    - `LoanOperations`: `issueLoan()`, `returnLoan()`.
    - `MemberManagement`: `addMember()`, `removeMember()`.
    - `Librarian`: Updated to use `LoanOperations` and `MemberManagement`.

### Stage 5: Dependency Inversion Principle (DIP) in System Integration

- **Classes & Methods:**
    - `NotificationService`: An interface with `sendNotification()`.
    - `EmailNotification`, `SMSNotification`: Implement `NotificationService`.
    - `NotificationManager`: Uses `NotificationService` for sending notifications.

### Stage 6: Implementing Composition Over Inheritance

- **Classes & Methods:**
    - `MemberType`: `getMemberTypeDetails()`.
    - `LoanPolicy`: `getLoanPolicyDetails()`.
    - `Member`: Composed with `MemberType` and `LoanPolicy` instead of inheritance.

### Stage 7: Custom Collector for Data Analysis

- **Classes & Methods:**
    - `LibraryUsageStatistics`: A class to hold statistical data.
    - `UsageStatisticsCollector`: A custom Stream Collector that collects data into `LibraryUsageStatistics`.
    - `ReportGenerator`: Updated to use `UsageStatisticsCollector`.

### Stage 8: Advanced Features and Real-World Simulation

- **Classes & Methods:**
    - `ReservationSystem`: `reserveBook()`, `cancelReservation()`.
    - `FeeCalculator`: `calculateLateFee()`.
    - `AuthenticationSystem`: `login()`, `logout()`, `authenticateUser()`.




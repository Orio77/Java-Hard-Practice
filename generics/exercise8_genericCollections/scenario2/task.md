# Exercise Documentation

## Classes to Create

1. `Appointment`
2. `Meeting`
3. `Interview`
4. `AppointmentManager`

## Class Methods to Implement

### `Appointment`

This class represents a generic appointment. It should contain necessary information about an appointment such as start time, end time, and participants.

### `Meeting` and `Interview`

These classes extend the `Appointment` class. They represent specific types of appointments and should contain additional information specific to their type.

### `AppointmentManager<T extends Appointment>`

This class is responsible for managing appointments. It should contain the following methods:

- `addAppointment(T appointment)`: This method should add an appointment of any type that extends `Appointment`.
    
- `sortAppointments()`: This method should sort appointments based on their start times.
    
- `queryAppointments(LocalDateTime start, LocalDateTime end)`: This method should return a list of appointments within a given time range.
    
- `handleAppointment(T appointment)`: This method should process an appointment of any type.
    

## General Overview

The `AppointmentManager` class is the main class in this exercise. It uses Java Generics with bounded type parameters to ensure compatibility with specific appointment types and type safety. The `Appointment` class is the base class for different appointments. The `Meeting` and `Interview` classes represent different types of appointments.

The `AppointmentManager` class has methods to add, sort, query, and handle appointments. It uses the generic type `T` in method parameters, allowing for flexibility in managing appointments of different types.

## Example Workflow

1. Create a `Meeting` or `Interview` object with necessary information.
2. Create an `AppointmentManager` object.
3. Call the `addAppointment` method of the `AppointmentManager` object with the `Meeting` or `Interview` object as a parameter.
4. The `AppointmentManager` adds the appointment to its collection.
5. Call the `sortAppointments` method of the `AppointmentManager` object to sort the appointments based on their start times.
6. Call the `queryAppointments` method of the `AppointmentManager` object with a start and end time as parameters to get a list of appointments within a given time range.
7. Call the `handleAppointment` method of the `AppointmentManager` object with the `Meeting` or `Interview` object as a parameter to process the appointment.
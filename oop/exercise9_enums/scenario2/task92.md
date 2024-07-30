**Advanced Traffic Light System**

- **Task 1**: Create an enum `TrafficLight` with the constants `RED`, `YELLOW`, `GREEN`. Each constant should have a property `duration` that represents the duration of the light in seconds. Implement a method `nextLight()` in the enum that returns the next traffic light in the sequence (RED -> GREEN -> YELLOW -> RED).
    - `RED`: The duration should be 60 seconds.
    - `YELLOW`: The duration should be 10 seconds.
    - `GREEN`: The duration should be 50 seconds.
- **Task 2**: Create a class `TrafficLightController` with a method `start()`. This method should simulate the traffic light sequence by printing the current light and its duration, then waiting for the duration before moving to the next light. Use the `nextLight()` method from the `TrafficLight` enum to get the next light.
- **Task 3**: Extend the `TrafficLight` enum to include a `colorCode` property that represents the RGB color code of the light. Implement a method `getColorCode()` that returns this color code.
    - `RED`: The color code should be "#FF0000".
    - `YELLOW`: The color code should be "#FFFF00".
    - `GREEN`: The color code should be "#00FF00".

**Further practise**:

1. **Advanced Traffic Light System – Enhanced Details**:
    - **Pedestrian Light**: Create an enum `PedestrianLight` with the constants `WALK`, `DONT_WALK`. Each constant should have a property `duration` that represents the duration of the light in seconds. Implement a method `nextLight()` in the enum that returns the next pedestrian light in the sequence (WALK -> DONT_WALK -> WALK).
    - **Traffic Light Controller**: Extend the `TrafficLightController` class to control both the traffic lights and the pedestrian lights. The pedestrian lights should change in sync with the traffic lights (e.g., when the traffic light is GREEN, the pedestrian light should be DONT_WALK).
2. **Traffic Light System with Sensors – Enhanced Details**:
    - **Traffic Light**: Extend the `TrafficLight` enum to include a `sensorTriggered` property that represents whether a sensor (e.g., a car sensor or a pedestrian button) has been triggered. Implement a method `triggerSensor()` that sets this property to true.
    - **Traffic Light Controller**: Extend the `TrafficLightController` class to check the `sensorTriggered` property of the lights. If a sensor is triggered, the controller should immediately change to the appropriate light (e.g., if the pedestrian button is pressed, change the traffic light to RED and the pedestrian light to WALK).
3. **Customizable Traffic Light Sequence – Enhanced Details**:
    - **Traffic Light Sequence**: Create an interface `TrafficLightSequence` with a method `nextLight()`. Implement different classes for different sequences (e.g., `StandardSequence`, `SensorTriggeredSequence`).
    - **Traffic Light Controller**: Extend the `TrafficLightController` class to use a `TrafficLightSequence` to determine the next light. The sequence should be passed as a parameter to the `start()` method.
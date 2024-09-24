// Condition.java
package com.smarthome;

public class Condition {
    private int deviceId;
    private String operator;
    private int value;

    public Condition(int deviceId, String operator, int value) {
        this.deviceId = deviceId;
        this.operator = operator;
        this.value = value;
    }

    public boolean evaluate(SmartHomeHub hub) {
        Device device = hub.getDeviceById(deviceId);
        if (device instanceof Thermostat) {
            Thermostat thermostat = (Thermostat) device;
            int currentTemperature = thermostat.getTemperature();

            switch (operator) {
                case ">":
                    return currentTemperature > value;
                case "<":
                    return currentTemperature < value;
                case "=":
                    return currentTemperature == value;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        } else {
            throw new IllegalArgumentException("Condition can only be applied to a thermostat.");
        }
    }
}

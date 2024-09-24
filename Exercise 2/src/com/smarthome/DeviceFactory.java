package com.smarthome;

public class DeviceFactory {
    public static Device createDevice(int id, String type, int temperature) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, temperature);
            case "door lock":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}

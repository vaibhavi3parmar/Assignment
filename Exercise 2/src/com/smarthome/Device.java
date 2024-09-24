// Device.java
package com.smarthome;

public abstract class Device {
    protected int id;
    protected String type;
    protected String status; // Can be "on" or "off" for lights and doors

    public Device(int id, String type) {
        this.id = id;
        this.type = type;
        this.status = "off"; // Default status for devices
    }

    public abstract void turnOn();

    public abstract void turnOff();

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }
}

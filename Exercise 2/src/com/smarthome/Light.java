// Light.java
package com.smarthome;

public class Light extends Device {

    public Light(int id) {
        super(id, "light");
    }

    @Override
    public void turnOn() {
        status = "on";
        System.out.println("Device ID " + id + " is now ON.");
    }

    @Override
    public void turnOff() {
        status = "off";
        System.out.println("Device ID " + id + " is now OFF.");
    }
}

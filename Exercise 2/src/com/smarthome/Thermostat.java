
// Thermostat.java
package com.smarthome;

public class Thermostat extends Device {
    private int temperature;

    public Thermostat(int id, int temperature) {
        super(id, "thermostat");
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        status = "on";
        System.out.println("Thermostat ID " + id + " is now ON.");
    }

    @Override
    public void turnOff() {
        status = "off";
        System.out.println("Thermostat ID " + id + " is now OFF.");
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}

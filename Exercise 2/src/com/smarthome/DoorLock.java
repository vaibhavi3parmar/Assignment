
// DoorLock.java
package com.smarthome;

public class DoorLock extends Device {

    public DoorLock(int id) {
        super(id, "door lock");
    }

    @Override
    public void turnOn() {
        status = "unlocked"; // Assuming turning on unlocks the door
        System.out.println("Door Lock ID " + id + " is now UNLOCKED.");
    }

    @Override
    public void turnOff() {
        status = "locked";
        System.out.println("Door Lock ID " + id + " is now LOCKED.");
    }
}

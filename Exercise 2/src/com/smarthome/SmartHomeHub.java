package com.smarthome;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeHub {
    private List<Device> devices;
    private List<ScheduledTask> scheduledTasks; // List to hold scheduled tasks

    public SmartHomeHub() {
        devices = new ArrayList<>();
        scheduledTasks = new ArrayList<>();
    }

    // Method to add a device
    public void addDevice(int id, String type, int temperature) {
        switch (type.toLowerCase()) {
            case "light":
                devices.add(new Light(id));
                break;
            case "thermostat":
                devices.add(new Thermostat(id, temperature));
                break;
            case "door lock":
                devices.add(new DoorLock(id));
                break;
            default:
                System.out.println("Unknown device type: " + type);
        }
    }

    // Method to display all devices
    public void displayDevices() {
        for (Device device : devices) {
            if (device instanceof Thermostat) {
                Thermostat thermostat = (Thermostat) device;
                System.out.println("Thermostat ID: " + thermostat.getId() + ", Type: " + thermostat.getType() +
                        ", Status: " + thermostat.getStatus() + ", Temperature: " + thermostat.getTemperature());
            } else {
                System.out.println("Device ID: " + device.getId() + ", Type: " + device.getType() + ", Status: "
                        + device.getStatus());
            }
        }
    }

    // Method to turn on a device by ID
    public void turnOnDevice(int id) {
        Device device = getDeviceById(id);
        if (device != null) {
            device.turnOn();
        } else {
            System.out.println("Device ID " + id + " not found.");
        }
    }

    // Method to turn off a device by ID
    public void turnOffDevice(int id) {
        Device device = getDeviceById(id);
        if (device != null) {
            device.turnOff();
        } else {
            System.out.println("Device ID " + id + " not found.");
        }
    }

    // Method to remove a device by ID
    public void removeDevice(int id) {
        Device deviceToRemove = getDeviceById(id);
        if (deviceToRemove != null) {
            devices.remove(deviceToRemove);
            System.out.println("Device ID " + id + " has been removed.");
        } else {
            System.out.println("Device ID " + id + " not found.");
        }
    }

    // Method to get a device by ID
    public Device getDeviceById(int id) {
        for (Device device : devices) {
            if (device.getId() == id) {
                return device;
            }
        }
        return null; // or throw an exception if preferred
    }

    // Method to schedule a task
    public void scheduleTask(int deviceId, String time, String action) {
        ScheduledTask task = new ScheduledTask(deviceId, time, action);
        scheduledTasks.add(task);
        System.out.println("Scheduled Task: Device " + deviceId + " will " + action + " at " + time);
    }

    // You can add a method to evaluate scheduled tasks here
    // Example: A method to check the current time against scheduled tasks and
    // execute if needed.
}

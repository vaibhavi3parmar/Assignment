package com.smarthome;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub();

        // Initialize some devices
        hub.addDevice(1, "light", 0); // Light (off)
        hub.addDevice(2, "thermostat", 70); // Thermostat
        hub.addDevice(3, "door lock", 0); // Door lock (locked)

        // Display initial device status
        hub.displayDevices();

        Scanner scanner = new Scanner(System.in);
        String command;

        // Main loop for command input
        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim();

            // Exit the loop if the user types 'exit'
            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            // Process the command
            try {
                processCommand(hub, command);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Display updated device status
            hub.displayDevices();
        }

        scanner.close();
    }

    private static void processCommand(SmartHomeHub hub, String command) {
        String[] parts = command.split(" ");

        switch (parts[0].toLowerCase()) {
            case "turnon":
                if (parts.length != 2)
                    throw new IllegalArgumentException("Usage: turnon <device_id>");
                int turnOnId = Integer.parseInt(parts[1]);
                hub.turnOnDevice(turnOnId);
                break;
            case "turnoff":
                if (parts.length != 2)
                    throw new IllegalArgumentException("Usage: turnoff <device_id>");
                int turnOffId = Integer.parseInt(parts[1]);
                hub.turnOffDevice(turnOffId);
                break;
            case "schedule":
                if (parts.length < 4)
                    throw new IllegalArgumentException("Usage: schedule <device_id> <time> <action> [<condition>]...");
                int scheduleId = Integer.parseInt(parts[1]);
                String time = parts[2];
                String action = parts[3];
                ScheduledTask task = new ScheduledTask(scheduleId, action, time);

                // Parse conditions if present
                for (int i = 4; i < parts.length; i += 3) {
                    int conditionDeviceId = Integer.parseInt(parts[i]);
                    String operator = parts[i + 1];
                    int conditionValue = Integer.parseInt(parts[i + 2]);
                    task.addCondition(new Condition(conditionDeviceId, operator, conditionValue));
                }

                hub.scheduleTask(scheduleId, action, time);
                break;
            case "remove":
                if (parts.length != 2)
                    throw new IllegalArgumentException("Usage: remove <device_id>");
                int removeId = Integer.parseInt(parts[1]);
                hub.removeDevice(removeId);
                break;
            case "status":
                hub.displayDevices();
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + parts[0]);
        }
    }
}

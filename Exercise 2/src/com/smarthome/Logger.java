package com.smarthome;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String LOG_FILE = "smart_home_log.txt";

    public static void log(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = timestamp + " - " + message;

        // Print to console
        System.out.println(logEntry);

        // Append to log file
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logEntry + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
}

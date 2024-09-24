package com.smarthome;

public class Trigger {
    private int deviceId;
    private String condition;
    private int threshold; // e.g., temperature
    private String action;

    public Trigger(int deviceId, String condition, int threshold, String action) {
        this.deviceId = deviceId;
        this.condition = condition;
        this.threshold = threshold;
        this.action = action;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public String getCondition() {
        return condition;
    }

    public int getThreshold() {
        return threshold;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Trigger: If device " + deviceId + " meets condition (" + condition + " " + threshold + "), then "
                + action;
    }
}

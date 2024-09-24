package com.smarthome;

import java.util.ArrayList;
import java.util.List;

public class ScheduledTask {
    private int deviceId;
    private List<Condition> conditions;
    private String action;
    private String time;

    public ScheduledTask(int deviceId, String action, String time) {
        this.deviceId = deviceId;
        this.action = action;
        this.time = time;
        this.conditions = new ArrayList<>();
    }

    public void addCondition(Condition condition) {
        conditions.add(condition);
    }

    public boolean evaluateConditions(SmartHomeHub hub) {
        for (Condition condition : conditions) {
            if (!condition.evaluate(hub)) {
                return false;
            }
        }
        return true;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public String getAction() {
        return action;
    }

    public String getTime() {
        return time;
    }

    public List<Condition> getConditions() {
        return conditions;
    }
}

package com.test.tracking.model;

import java.util.Date;

public class Condition {
    private BaseCondition userCondition;
    private String time;

    public Condition(BaseCondition userCondition, String time) {
        this.userCondition = userCondition;
        this.time = time;
    }

    public BaseCondition getUserCondition() {
        return userCondition;
    }

    public void setUserCondition(BaseCondition userCondition) {
        this.userCondition = userCondition;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

package com.test.tracking;

import com.test.tracking.model.Condition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UtilFunctions {

    public static String getCurrentTimeAsString() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ssXXX");
        return formatter.format(date);
    }

    public static String getThirtyMinutesBeforeAsString(int count) {
        long currentMillis = System.currentTimeMillis();
        long thirtyMinToMillis = 30 * 60 * 1000 * count;

        currentMillis -= thirtyMinToMillis;

        Date date = new Date(currentMillis);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ssXXX");

        return formatter.format(date);
    }

    public static Condition getLastConditionOfPerson(List<Condition> conditionList) {
        if(conditionList == null || conditionList.isEmpty()) return null;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ssXXX");
        try {
            long shortestMillisecond = formatter.parse(conditionList.get(0).getTime()).getTime();
            int shortestPos = 0;

            for(int i = 1;i < conditionList.size();i++) {
                long currentConditionMillis = formatter.parse(conditionList.get(i).getTime()).getTime();
                if(shortestMillisecond > currentConditionMillis) {
                    shortestMillisecond = currentConditionMillis;
                    shortestPos = i;
                }
            }

            return conditionList.get(shortestPos);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return conditionList.get(0);
    }
}

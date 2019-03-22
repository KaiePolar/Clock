package com.a.clock.AdditionalClasses;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import java.util.Calendar;

public class Alarm {
    final Calendar calendar = Calendar.getInstance();
    private AlarmManager alarmManager;
    private Intent intent;
    private PendingIntent pendingIntent;

    public Alarm(String hour_string, String minute_string, Context context) {
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour_string));
        calendar.set(Calendar.MINUTE, Integer.parseInt(minute_string));
        if (calendar.before(Calendar.getInstance())) {
            calendar.add(Calendar.DATE, 1);
        }

        intent = new Intent(context, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        } else {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }

    }

    public void cancelAlarm() {
        alarmManager.cancel(pendingIntent);
    }
}

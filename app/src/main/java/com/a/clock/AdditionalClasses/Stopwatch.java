package com.a.clock.AdditionalClasses;

import android.os.Handler;
import android.os.SystemClock;

import com.a.clock.Presenters.StopwatchPresenter;

public class Stopwatch {
    private static Stopwatch instance=null;
    private Handler handler;
    private long millisecondTime, startTime, timeBuff, updateTime = 0L;
    private int seconds, minutes, milliSeconds;
    private Runnable runnable;
    private boolean isActive=false;
    private StopwatchPresenter presenter;

    private Stopwatch(final StopwatchPresenter presenter) {
        this.presenter = presenter;
        handler = new Handler();
        runnable = new Runnable() {

            public void run() {


                millisecondTime = SystemClock.uptimeMillis() - startTime;

                updateTime = timeBuff + millisecondTime;

                seconds = (int) (updateTime / 1000);

                minutes = seconds / 60;

                seconds = seconds % 60;

                milliSeconds = (int) (updateTime % 1000);

                String s = String.format("%02d", minutes) + ":"
                        + String.format("%02d", seconds) + ":"
                        + String.format("%03d", milliSeconds);

                presenter.setTextViewTime(s);


                handler.postDelayed(this, 0);


            }
        };
    }

    public static Stopwatch getInstance(StopwatchPresenter presenter){
        if(instance==null){
            instance = new Stopwatch(presenter);
        }
        return instance;
    }

    public void startStopwatch() {
        startTime = SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);
        isActive = true;
    }

    public void pauseStopwatch() {
        timeBuff += millisecondTime;
        handler.removeCallbacks(runnable);
        isActive = false;
    }

    public void resetStopwatch() {
        millisecondTime = 0L;
        startTime = 0L;
        timeBuff = 0L;
        updateTime = 0L;
        seconds = 0;
        minutes = 0;
        milliSeconds = 0;
    }

    public boolean isActive() {
        return isActive;
    }

}

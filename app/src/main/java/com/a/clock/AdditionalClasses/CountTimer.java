package com.a.clock.AdditionalClasses;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.a.clock.Presenters.TimerPresenter;

public class CountTimer {
    private long millisInFuture;
    private long countDownInterval;
    private TimerPresenter presenter;
    private Context context;
    private static CountTimer instance;
    private boolean isActive;

    private CountTimer(long pMillisInFuture, long pCountDownInterval, TimerPresenter presenter, Context context) {
        this.context = context;
        this.millisInFuture = pMillisInFuture;
        this.presenter = presenter;
        this.countDownInterval = pCountDownInterval;
        isActive = false;
        init();
    }


    public static CountTimer getInstance(long pMillisInFuture, long pCountDownInterval, TimerPresenter presenter, Context context) {
        if (instance == null) {
            instance = new CountTimer(pMillisInFuture, pCountDownInterval, presenter, context);
        }
        return instance;
    }


    public void stop() {
        isActive = false;
    }

    public long getCurrentTime() {
        return millisInFuture;
    }

    public void start() {
        isActive = true;
    }

    private void init() {
        final Handler handler = new Handler();
        Log.d("status", "starting");
        final Runnable counter = new Runnable() {

            public void run() {
                long sec = millisInFuture / 1000;
                if (isActive) {
                    if (millisInFuture <= 0) {
                        Log.d("status", "done");
                        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();
                        presenter.makeArrowsVisible();
                        presenter.switchStartPauseButtons();
                        isActive=false;
                    } else {
                        Log.d("status", sec + " seconds remain");
                        millisInFuture -= countDownInterval;
                        presenter.reduceSeconds();
                        handler.postDelayed(this, countDownInterval);
                    }
                } else {
                    Log.d("status", sec + " seconds remain and timer has stopped!");
                    handler.postDelayed(this, countDownInterval);
                }
            }
        };

        handler.postDelayed(counter, countDownInterval);
    }

    public boolean isActive() {
        return isActive;
    }
}

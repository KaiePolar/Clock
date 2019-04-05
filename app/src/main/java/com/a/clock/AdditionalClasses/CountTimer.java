package com.a.clock.AdditionalClasses;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.a.clock.Presenters.TimerPresenter;

public class CountTimer {
    private long millisInFuture;
    private long countDownInterval;
    private boolean status;
    private TimerPresenter presenter;
    private Context context;

    public CountTimer(long pMillisInFuture, long pCountDownInterval, TimerPresenter presenter, Context context) {
        this.context = context;
        this.millisInFuture = pMillisInFuture;
        this.presenter = presenter;
        this.countDownInterval = pCountDownInterval;
        status = false;
        init();
    }

    public void stop() {
        status = false;
    }

    public long getCurrentTime() {
        return millisInFuture;
    }

    public void start() {
        status = true;
    }

    public void init() {
        final Handler handler = new Handler();
        Log.d("status", "starting");
        final Runnable counter = new Runnable() {

            public void run() {
                long sec = millisInFuture / 1000;
                if (status) {
                    if (millisInFuture <= 0) {
                        Log.d("status", "done");
                        Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show();
                        presenter.switchStartPauseButtons();
                    } else {
                        Log.d("status", Long.toString(sec) + " seconds remain");
                        millisInFuture -= countDownInterval;
                        presenter.reduceSeconds();
                        handler.postDelayed(this, countDownInterval);
                    }
                } else {
                    Log.d("status", Long.toString(sec) + " seconds remain and timer has stopped!");
                    handler.postDelayed(this, countDownInterval);
                }
            }
        };

        handler.postDelayed(counter, countDownInterval);
    }
}

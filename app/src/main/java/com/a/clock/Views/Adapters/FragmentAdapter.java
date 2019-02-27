package com.a.clock.Views.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.a.clock.R;
import com.a.clock.Views.Fragments.AlarmFragment;
import com.a.clock.Views.Fragments.StopwatchFragment;
import com.a.clock.Views.Fragments.TimeFragment;
import com.a.clock.Views.Fragments.TimerFragment;


public class FragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AlarmFragment();
        } else if (position == 1) {
            return new StopwatchFragment();
        } else if (position == 2) {
            return new TimerFragment();
        } else if (position == 3) {
            return new TimeFragment();
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.alarm);
            case 1:
                return context.getString(R.string.stopwatch);
            case 2:
                return context.getString(R.string.timer);
            case 3:
                return context.getString(R.string.time);
            default:
                return null;
        }
    }}

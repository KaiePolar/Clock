package com.a.clock.Interfaces;

import com.a.clock.Views.Fragments.StopwatchFragment;
import com.a.clock.Views.Fragments.TimerFragment;

import java.util.ArrayList;

public interface Presenter {
    void bindView(View view);

    void unbindView();

    ArrayList<String> returnListForAdapter(ArrayList<String> namesList, ArrayList<String> timesList);

    interface TimerPresenter {
        void bindView(TimerFragment view);

        void unbindView();

        void reduceSeconds();

        void switchStartPauseButtons();

        void makeArrowsVisible();
    }

    interface StopwatchPresenter {
        void bindView(StopwatchFragment view);
        void setTextViewTime(String s);
        void unbindView();
    }


}


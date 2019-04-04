package com.a.clock.Interfaces;

import com.a.clock.Views.Fragments.TimerFragment;

import java.util.ArrayList;

public interface Presenter {
    void bindView(View view);
    void unbindView();
    ArrayList<String> returnListForAdapter(ArrayList<String> namesList,ArrayList<String> timesList);

    interface TimerPresenter{
    void bindView(TimerFragment view);
    void reduceSeconds();
    }

}


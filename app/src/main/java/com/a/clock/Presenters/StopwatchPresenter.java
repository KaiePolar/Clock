package com.a.clock.Presenters;

import com.a.clock.Interfaces.Presenter;
import com.a.clock.Interfaces.View;

import java.util.ArrayList;

public class StopwatchPresenter implements Presenter {

    private View view;

    @Override
    public void bindView(View view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        view = null;
    }

    @Override
    public ArrayList<String> returnListForAdapter(ArrayList<String> namesList, ArrayList<String> timesList) {
        return null;
    }


}

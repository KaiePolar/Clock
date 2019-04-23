package com.a.clock.Presenters;

import com.a.clock.Interfaces.Presenter;
import com.a.clock.Views.Fragments.StopwatchFragment;

public class StopwatchPresenter implements Presenter.StopwatchPresenter {

    private StopwatchFragment view;

    @Override
    public void bindView(StopwatchFragment view) {
        this.view = view;
    }

    @Override
    public void setTextViewTime(String s) {
        view.setTextViewTime(s);
    }

    @Override
    public void unbindView() {
        view = null;
    }

}

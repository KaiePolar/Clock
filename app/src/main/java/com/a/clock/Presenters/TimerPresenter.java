package com.a.clock.Presenters;

import com.a.clock.Interfaces.Presenter;
import com.a.clock.Views.Fragments.TimerFragment;

public class TimerPresenter implements Presenter.TimerPresenter {

    private TimerFragment view;

    @Override
    public void bindView(TimerFragment view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        view = null;
    }

    @Override
    public void reduceSeconds() {
        view.reduceSeconds();
    }

    @Override
    public void switchStartPauseButtons() {
        view.switchStartPauseButtons();
    }

    @Override
    public void makeArrowsVisible() {
        view.makeArrowsVisible();
    }

}

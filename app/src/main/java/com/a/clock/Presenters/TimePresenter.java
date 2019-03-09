package com.a.clock.Presenters;

import android.content.Context;

import com.a.clock.Interfaces.Presenter;
import com.a.clock.Interfaces.View;
import com.a.clock.Repositories.TimeRepository.TimeItem;
import com.a.clock.Repositories.TimeRepository.TimeRepository;

import java.util.ArrayList;
import java.util.List;

public class TimePresenter implements Presenter {

    private View view;
    private TimeRepository repository;

    public TimePresenter(Context context) {
        this.repository = new TimeRepository(context);
    }

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
        view.setRecyclerView(namesList, timesList);
        return null;
    }

    public List<TimeItem> getElementsList() {
        return repository.getTimeDatabaseDao().getAll();
    }


}

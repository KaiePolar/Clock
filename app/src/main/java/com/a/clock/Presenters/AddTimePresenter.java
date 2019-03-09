package com.a.clock.Presenters;

import android.content.Context;
import android.util.Log;

import com.a.clock.Interfaces.Presenter;
import com.a.clock.Interfaces.View;
import com.a.clock.Repositories.TimeRepository.TimeItem;
import com.a.clock.Repositories.TimeRepository.TimeRepository;

import java.util.ArrayList;

public class AddTimePresenter implements Presenter {

    private View view;
    private TimeRepository repository;
    private Context context;

    public AddTimePresenter(Context context) {
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
    public ArrayList<String> returnListForAdapter(ArrayList<String> namesList,ArrayList<String> timesList) {
        view.setRecyclerView(namesList, timesList);
        return null;
    }

    public void addItem(String name, String time) {
        TimeItem timeItem = new TimeItem();
        timeItem.cityname = name;
        timeItem.citytime = time;
        repository.getTimeDatabaseDao().insert(timeItem);
        Log.d("TAG", name + time);
    }
}

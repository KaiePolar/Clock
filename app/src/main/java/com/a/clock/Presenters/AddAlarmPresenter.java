package com.a.clock.Presenters;

import android.content.Context;

import com.a.clock.Interfaces.Presenter;
import com.a.clock.Interfaces.Repository;
import com.a.clock.Interfaces.View;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.AlarmRepository.AlarmRepository;

import java.util.ArrayList;

public class AddAlarmPresenter implements Presenter {

    private View view;
    private Repository repository;
    private Context context;

    public AddAlarmPresenter(Context context) {
        this.context = context;
        repository = new AlarmRepository(context);
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
        return null;
    }

    public void addAlarmButtonClicked(AlarmItem alarmItem) {
        repository.getAlarmDatabaseDao().insert(alarmItem);
    }
}

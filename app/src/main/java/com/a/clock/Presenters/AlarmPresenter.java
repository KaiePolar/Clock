package com.a.clock.Presenters;

import android.content.Context;

import com.a.clock.Interfaces.Presenter;
import com.a.clock.Interfaces.Repository;
import com.a.clock.Interfaces.View;
import com.a.clock.Repositories.AlarmRepository.AlarmDao;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.AlarmRepository.AlarmRepository;

import java.util.ArrayList;
import java.util.List;

public class AlarmPresenter implements Presenter {

    private View view;
    private Repository repository;

    public AlarmPresenter(Context context){
        this.repository = new AlarmRepository(context);

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


    public List<AlarmItem> getElementsList(){
        return repository.getAlarmDatabaseDao().getAll();
    }

    public AlarmDao getDatabaseDao(){
        return repository.getAlarmDatabaseDao();
    }

    public void updateItem(boolean switchEnabled, int id) {
        AlarmItem alarmItem = repository.getAlarmDatabaseDao().getById(id);
        alarmItem.enabled = switchEnabled;
        repository.getAlarmDatabaseDao().update(alarmItem);
    }

    public void deleteItem(AlarmItem alarmItem) {
        repository.getAlarmDatabaseDao().delete(alarmItem);
        view.refreshRecyclerViewAdapter();
    }

    public void showDeleteDialog() {
        view.showDeleteDialog();
    }

    public void hideDialog() {
        view.hideDeleteDialog();
    }
}

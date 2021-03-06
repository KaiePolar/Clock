package com.a.clock.Repositories.AlarmRepository;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.a.clock.Interfaces.Repository;
import com.a.clock.Repositories.AlarmDatabase;
import com.a.clock.Repositories.TimeRepository.TimeDao;
import com.a.clock.Repositories.TimeRepository.TimeItem;

import java.util.List;

public class AlarmRepository implements Repository {
    private Context context;

    public AlarmRepository(Context context){
        this.context = context;
        Room.databaseBuilder(context, AlarmDatabase.class,"AlarmDatabase").allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }

    public List<AlarmItem> getAlarmElementsList() {
        return getAlarmDatabaseDao()
                .getAll();
    }

    @Override
    public List<TimeItem> getTimeElementsList() {
        return null;
    }

    @Override
    public AlarmDao getAlarmDatabaseDao() {
       return  AlarmDatabase.getDatabaseInstance(context)
               .alarmDao();
    }

    @Override
    public TimeDao getTimeDatabaseDao() {
        return null;
    }
}

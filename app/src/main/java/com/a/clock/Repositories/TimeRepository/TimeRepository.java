package com.a.clock.Repositories.TimeRepository;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.a.clock.Interfaces.Repository;
import com.a.clock.Repositories.AlarmRepository.AlarmDao;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.TimeDatabase;

import java.util.List;

public class TimeRepository implements Repository {
    private Context context;

    public TimeRepository(Context context) {
        this.context = context;
        Room.databaseBuilder(context, TimeDatabase.class, "database").allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }

    public List<AlarmItem> getAlarmElementsList() {
        return null;
    }

    @Override
    public List<TimeItem> getTimeElementsList() {
        return getTimeDatabaseDao().getAll();
    }

    @Override
    public AlarmDao getAlarmDatabaseDao() {
        return null;
    }

    @Override
    public TimeDao getTimeDatabaseDao() {
        return TimeDatabase.getDatabaseInstance(context).timeDao();
    }
}


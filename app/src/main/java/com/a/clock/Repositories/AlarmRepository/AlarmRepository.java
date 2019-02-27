package com.a.clock.Repositories.AlarmRepository;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.a.clock.Interfaces.Repository;
import com.a.clock.Repositories.ClockDatabase;

import java.util.List;

public class AlarmRepository implements Repository {
    private Context context;

    public AlarmRepository(Context context){
        this.context = context;
        Room.databaseBuilder(context, ClockDatabase.class,"database").allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }

    public List<AlarmItem> getElementsList(){
        return getDatabaseDao()
                .getAll();
    }

    @Override
    public AlarmDao getDatabaseDao() {
       return  ClockDatabase.getDatabaseInstance(context)
               .clockDao();
    }
}

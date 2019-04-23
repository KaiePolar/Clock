package com.a.clock.Repositories;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.a.clock.Repositories.TimeRepository.TimeDao;
import com.a.clock.Repositories.TimeRepository.TimeItem;

@Database(entities = {TimeItem.class}, version = 15)
public abstract class TimeDatabase extends RoomDatabase {
    private static TimeDatabase INSTANCE;

    public static TimeDatabase getDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), TimeDatabase.class, "TimeDatabase")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract TimeDao timeDao();
}
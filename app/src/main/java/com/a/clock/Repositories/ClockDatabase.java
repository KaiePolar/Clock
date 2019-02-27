package com.a.clock.Repositories;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.a.clock.Repositories.AlarmRepository.AlarmDao;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;

@Database(entities = {AlarmItem.class}, version = 7)
public abstract class ClockDatabase extends RoomDatabase {
    private static ClockDatabase INSTANCE;

    public abstract AlarmDao clockDao();

    public static ClockDatabase getDatabaseInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), ClockDatabase.class, "user-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}

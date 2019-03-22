package com.a.clock.Repositories.AlarmRepository;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class AlarmItem {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String time;

    public boolean enabled;

    public boolean vibrating;

    public boolean repeating;

    //public Alarm alarm;
}

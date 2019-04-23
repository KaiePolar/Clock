package com.a.clock.Repositories.TimeRepository;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class TimeItem {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String citytime;

    public String cityname;

    public int position;


}

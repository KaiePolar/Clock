package com.a.clock.Repositories.AlarmRepository;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.a.clock.Repositories.AlarmRepository.AlarmItem;

import java.util.List;

@Dao
public interface AlarmDao {

    @Query("SELECT * FROM alarmitem")
    List<AlarmItem> getAll();

    @Query("SELECT * FROM alarmitem WHERE id = :id")
    AlarmItem getById(int id);

    @Insert
    void insert(AlarmItem alarmItem);

    @Update
    void update(AlarmItem alarmItem);

    @Delete
    void delete(AlarmItem alarmItem);

}
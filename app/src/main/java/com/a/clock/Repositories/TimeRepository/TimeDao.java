package com.a.clock.Repositories.TimeRepository;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TimeDao {

    @Query("SELECT * FROM timeitem")
    List<TimeItem> getAll();

    @Query("SELECT * FROM timeitem WHERE id = :id")
    TimeItem getById(int id);

    @Insert
    void insert(TimeItem timeItem);

    @Update
    void update(TimeItem timeItem);

    @Delete
    void delete(TimeItem timeItem);

}

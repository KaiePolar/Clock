package com.a.clock.Interfaces;

import com.a.clock.Repositories.AlarmRepository.AlarmDao;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.ClockDatabase;

import java.util.List;

public interface Repository {
    List<AlarmItem> getElementsList();
    AlarmDao getDatabaseDao();

}

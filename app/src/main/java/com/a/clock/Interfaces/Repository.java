package com.a.clock.Interfaces;

import com.a.clock.Repositories.AlarmRepository.AlarmDao;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.TimeRepository.TimeDao;
import com.a.clock.Repositories.TimeRepository.TimeItem;

import java.util.List;

public interface Repository {
    List<AlarmItem> getAlarmElementsList();

    List<TimeItem> getTimeElementsList();

    AlarmDao getAlarmDatabaseDao();

    TimeDao getTimeDatabaseDao();

}

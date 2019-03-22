package com.a.clock.Interfaces;

import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.TimeRepository.TimeItem;

import java.util.ArrayList;
import java.util.List;

public interface View {
    void setRecyclerView(ArrayList list1,ArrayList list2);

    void showDeleteDialog();

    void hideDeleteDialog();

    void setUpAlarmRecyclerViewAdapter(List<AlarmItem> all);

    void setUpTimeRecyclerViewAdapter(List<TimeItem> all);
}

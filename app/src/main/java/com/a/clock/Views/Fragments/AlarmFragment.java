package com.a.clock.Views.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a.clock.Presenters.AlarmPresenter;
import com.a.clock.R;
import com.a.clock.Views.Activities.AddAlarmActivity;
import com.a.clock.Views.Adapters.AlarmRecyclerViewAdapter;
import com.a.clock.Views.Adapters.TimeRecyclerViewAdapter;

import java.util.ArrayList;

public class AlarmFragment extends Fragment implements com.a.clock.Interfaces.View {

    private RecyclerView alarmRecyclerView;
    private FloatingActionButton addAlarmButton;
    private AlarmRecyclerViewAdapter alarmRecyclerViewAdapter;
    private AlarmPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new AlarmPresenter(getContext());
        presenter.bindView(this);

        View view = inflater.inflate(R.layout.fragment_alarm, container, false);

        RecyclerView alarmRecyclerView = view.findViewById(R.id.alarm_recycler_view);
        alarmRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        alarmRecyclerViewAdapter = new AlarmRecyclerViewAdapter(getContext(), presenter.getElementsList(),presenter);
        alarmRecyclerView.setAdapter(alarmRecyclerViewAdapter);
        addAlarmButton = view.findViewById(R.id.alarm_add_button);

        addAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddAlarmActivity.class);
                startActivity(intent);
            }
        });


        return view;

    }




    @Override
    public void setRecyclerView(ArrayList list1, ArrayList list2) {

    }
}

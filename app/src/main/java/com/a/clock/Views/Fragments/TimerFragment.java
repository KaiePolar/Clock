package com.a.clock.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.a.clock.Presenters.TimerPresenter;
import com.a.clock.R;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.TimeRepository.TimeItem;

import java.util.ArrayList;
import java.util.List;

public class TimerFragment extends Fragment implements com.a.clock.Interfaces.View {

    private TextView timerTextView;
    private Button timerButton;
    private TimerPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TimerPresenter();
        presenter.bindView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);


        timerButton = view.findViewById(R.id.timer_start_button);
        timerTextView = view.findViewById(R.id.timer_text_view);

        return view;
    }




    @Override
    public void setRecyclerView(ArrayList list1, ArrayList list2) {

    }

    @Override
    public void showDeleteDialog() {

    }

    @Override
    public void hideDeleteDialog() {

    }

    @Override
    public void setUpAlarmRecyclerViewAdapter(List<AlarmItem> all) {

    }

    @Override
    public void setUpTimeRecyclerViewAdapter(List<TimeItem> all) {

    }
}

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
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.TimeRepository.TimeItem;
import com.a.clock.Views.Activities.AddAlarmActivity;
import com.a.clock.Views.Adapters.AlarmRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class AlarmFragment extends Fragment implements com.a.clock.Interfaces.View {

    private RecyclerView alarmRecyclerView;
    private FloatingActionButton addAlarmButton;
    private AlarmRecyclerViewAdapter alarmRecyclerViewAdapter;
    private AlarmPresenter presenter;
    private AlarmDeleteBottomSheetDialogFragment alarmDeleteBottomSheetDialogFragment;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AlarmPresenter(getContext());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_alarm, container, false);

        addAlarmButton = view.findViewById(R.id.alarm_add_button);
        alarmDeleteBottomSheetDialogFragment = AlarmDeleteBottomSheetDialogFragment.newInstance();
        presenter.bindView(this);

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

    public void showDeleteDialog() {
        alarmDeleteBottomSheetDialogFragment.setPresenter(presenter);
        alarmDeleteBottomSheetDialogFragment.show(getActivity().getSupportFragmentManager(), "delete_bottom_sheet_dialog");
    }

    public void setUpAlarmRecyclerViewAdapter(List<AlarmItem> elements) {
        alarmRecyclerView = view.findViewById(R.id.alarm_recycler_view);
        alarmRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        alarmRecyclerViewAdapter = new AlarmRecyclerViewAdapter(getContext(), elements, presenter, alarmDeleteBottomSheetDialogFragment);
        alarmRecyclerView.setAdapter(alarmRecyclerViewAdapter);
        alarmRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void setUpTimeRecyclerViewAdapter(List<TimeItem> all) {

    }

    @Override
    public void hideDeleteDialog() {
        alarmDeleteBottomSheetDialogFragment.dismiss();
    }
}



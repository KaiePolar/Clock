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

import com.a.clock.Presenters.TimePresenter;
import com.a.clock.R;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.TimeRepository.TimeItem;
import com.a.clock.Views.Activities.AddTimeActivity;
import com.a.clock.Views.Adapters.TimeRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class TimeFragment extends Fragment implements com.a.clock.Interfaces.View {

    private RecyclerView timeRecyclerView;
    private FloatingActionButton addTimeButton;
    private TimePresenter presenter;
    private TimeRecyclerViewAdapter timeRecyclerViewAdapter;
    private TimeDeleteBottomSheetDialogFragment timeDeleteBottomSheetDialogFragment;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TimePresenter(getContext());
        presenter.bindView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_time, container, false);

        timeRecyclerView = view.findViewById(R.id.time_recycler_view);
        addTimeButton = view.findViewById(R.id.time_add_button);

        timeRecyclerView = view.findViewById(R.id.time_recycler_view);
        timeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        timeDeleteBottomSheetDialogFragment = TimeDeleteBottomSheetDialogFragment.newInstance();
        timeRecyclerViewAdapter = new TimeRecyclerViewAdapter(getContext(), presenter.getElementsList(), presenter, timeDeleteBottomSheetDialogFragment);
        timeRecyclerView.setAdapter(timeRecyclerViewAdapter);



        addTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddTimeActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }





    @Override
    public void setRecyclerView(ArrayList list1, ArrayList list2) {

    }

    @Override
    public void showDeleteDialog() {
        timeDeleteBottomSheetDialogFragment.setPresenter(presenter);
        timeDeleteBottomSheetDialogFragment.show(getActivity().getSupportFragmentManager(), "delete_bottom_sheet_dialog");
    }

    @Override
    public void hideDeleteDialog() {
        timeDeleteBottomSheetDialogFragment.dismiss();
    }

    @Override
    public void setUpAlarmRecyclerViewAdapter(List<AlarmItem> all) {

    }

    @Override
    public void setUpTimeRecyclerViewAdapter(List<TimeItem> all) {
        RecyclerView timeRecyclerView = view.findViewById(R.id.time_recycler_view);
        timeRecyclerViewAdapter = new TimeRecyclerViewAdapter(getContext(), presenter.getElementsList(), presenter, timeDeleteBottomSheetDialogFragment);
        timeRecyclerView.setAdapter(timeRecyclerViewAdapter);
        timeRecyclerViewAdapter.notifyDataSetChanged();
    }
}

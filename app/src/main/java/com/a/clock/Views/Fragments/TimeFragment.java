package com.a.clock.Views.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a.clock.Presenters.TimePresenter;
import com.a.clock.R;
import com.a.clock.Views.Activities.AddTimeActivity;

import java.util.ArrayList;

public class TimeFragment extends Fragment implements com.a.clock.Interfaces.View {

    private RecyclerView timeRecyclerView;
    private FloatingActionButton addTimeButton;
    private TimePresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TimePresenter();
        presenter.bindView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time, container, false);

        timeRecyclerView = view.findViewById(R.id.time_recycler_view);
        addTimeButton = view.findViewById(R.id.time_add_button);

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
}

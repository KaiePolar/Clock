package com.a.clock.Views.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.a.clock.AdditionalClasses.Stopwatch;
import com.a.clock.Presenters.StopwatchPresenter;
import com.a.clock.R;

import java.util.ArrayList;
import java.util.Arrays;

public class StopwatchFragment extends Fragment implements com.a.clock.Interfaces.View.StopwatchView {

    private StopwatchPresenter presenter;
    private TextView stopwatchTextView;
    private Button resetButton, lapButton;
    private FloatingActionButton startButton, pauseButton;

    private ListView lapsListView;
    private String[] ListElements = new String[]{};
    private ArrayList<String> ListElementsArrayList;
    private ArrayAdapter<String> adapter;
    private Stopwatch stopwatch;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new StopwatchPresenter();
        stopwatch = Stopwatch.getInstance(presenter);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        presenter.bindView(this);

        stopwatchTextView = view.findViewById(R.id.stopwatch_time_textview);
        startButton = view.findViewById(R.id.stopwatch_start_button);
        pauseButton = view.findViewById(R.id.stopwatch_pause_button);
        resetButton = view.findViewById(R.id.stopwatch_reset_button);
        lapButton = view.findViewById(R.id.stopwatch_lap_button);
        lapsListView = view.findViewById(R.id.stopwatch_laps_listview);

        if (stopwatch.isActive()) {
            startButton.setVisibility(View.GONE);
            pauseButton.setVisibility(View.VISIBLE);
        } else {
            startButton.setVisibility(View.VISIBLE);
            pauseButton.setVisibility(View.GONE);
        }

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,
                ListElementsArrayList
        );

        lapsListView.setAdapter(adapter);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                stopwatch.startStopwatch();
                resetButton.setEnabled(false);
                startButton.setVisibility(View.GONE);
                pauseButton.setVisibility(View.VISIBLE);

            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                stopwatch.pauseStopwatch();
                resetButton.setEnabled(true);
                pauseButton.setVisibility(View.GONE);
                startButton.setVisibility(View.VISIBLE);

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopwatch.resetStopwatch();

                stopwatchTextView.setText("00:00:000");

                ListElementsArrayList.clear();

                adapter.notifyDataSetChanged();
            }
        });

        lapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListElementsArrayList.add(stopwatchTextView.getText().toString());

                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public void setTextViewTime(String s) {
        stopwatchTextView.setText(s);
    }

}

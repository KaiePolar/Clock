package com.a.clock.Views.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TimePicker;

import com.a.clock.Presenters.AddAlarmPresenter;
import com.a.clock.R;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.TimeRepository.TimeItem;

import java.util.ArrayList;
import java.util.List;

public class AddAlarmActivity extends AppCompatActivity implements com.a.clock.Interfaces.View {

    private AddAlarmPresenter presenter;
    private Button setAlarmButton;
    private Button cancelAlarmButton;
    private TimePicker timePicker;
    private Switch switchButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        setAlarmButton = findViewById(R.id.set_alarm_button);
        cancelAlarmButton = findViewById(R.id.cancel_button);
        timePicker = findViewById(R.id.timePicker);
        switchButton = findViewById(R.id.vibe_switch);


        presenter = new AddAlarmPresenter(getApplicationContext());
        presenter.bindView(this);


        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hour_string = String.valueOf(timePicker.getCurrentHour());
                String minute_string = String.valueOf(timePicker.getCurrentMinute());
                if (timePicker.getCurrentMinute() < 10) {
                    minute_string = "0" + minute_string;
                }


                AlarmItem alarmItem = new AlarmItem();
                alarmItem.time = String.valueOf(hour_string + ":" + minute_string);
                alarmItem.enabled = true;
                presenter.addAlarmButtonClicked(alarmItem);

                Intent intent = new Intent(AddAlarmActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        cancelAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddAlarmActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
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

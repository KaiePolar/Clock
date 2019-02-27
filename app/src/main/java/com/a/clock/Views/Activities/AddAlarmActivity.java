package com.a.clock.Views.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import com.a.clock.Presenters.AlarmPresenter;
import com.a.clock.R;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;

import java.util.ArrayList;

public class AddAlarmActivity extends AppCompatActivity implements com.a.clock.Interfaces.View {

    private AlarmPresenter presenter;
    private Button setAlarmButton;
    private TimePicker timePicker;
    private Switch switchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        setAlarmButton = findViewById(R.id.set_alarm_button);
        timePicker = findViewById(R.id.timePicker);
        switchButton = findViewById(R.id.vibe_switch);


        presenter = new AlarmPresenter(getApplicationContext());
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
                presenter.getDatabaseDao().insert(alarmItem);
                Toast.makeText(getApplicationContext(), "inserted " + alarmItem.time + alarmItem.enabled, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddAlarmActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "all " + presenter.getElementsList(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void setRecyclerView(ArrayList list1, ArrayList list2) {

    }
}

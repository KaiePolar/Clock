package com.a.clock.Views.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.a.clock.AdditionalClasses.JsoupParser;
import com.a.clock.Interfaces.Presenter;
import com.a.clock.Presenters.AddTimePresenter;
import com.a.clock.R;
import com.a.clock.Views.Adapters.TimeRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class AddTimeActivity extends AppCompatActivity implements com.a.clock.Interfaces.View {

    private Button backButton;
    private TimeRecyclerViewAdapter timeRecyclerViewAdapter;
    private RecyclerView timeRecyclerView;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time);
        backButton = findViewById(R.id.back_button);

        presenter = new AddTimePresenter();
        presenter.bindView(this);
        JsoupParser jsoupParser = new JsoupParser(presenter);
        jsoupParser.execute();

        timeRecyclerView = findViewById(R.id.addTimeRecyclerView);
        timeRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        backButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTimeActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    public void setRecyclerView(ArrayList list1, ArrayList list2) {
        timeRecyclerViewAdapter = new TimeRecyclerViewAdapter(getApplicationContext(), list1, list2);
        timeRecyclerView.setAdapter(timeRecyclerViewAdapter);
    }
}

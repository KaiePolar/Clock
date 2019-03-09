package com.a.clock.Views.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.a.clock.AdditionalClasses.JsoupParser;
import com.a.clock.Interfaces.Presenter;
import com.a.clock.Presenters.AddTimePresenter;
import com.a.clock.R;
import com.a.clock.Views.Adapters.AddTimeRecyclerViewAdapter;

import java.util.ArrayList;

public class AddTimeActivity extends AppCompatActivity implements com.a.clock.Interfaces.View {

    private Button backButton;
    private AddTimeRecyclerViewAdapter addTimeRecyclerViewAdapter;
    private RecyclerView timeRecyclerView;
    private Presenter presenter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time);
        backButton = findViewById(R.id.back_button);

        presenter = new AddTimePresenter(getApplicationContext());
        presenter.bindView(this);
        final JsoupParser jsoupParser = new JsoupParser(presenter);
        jsoupParser.execute();

        timeRecyclerView = findViewById(R.id.addTimeRecyclerView);
        timeRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        swipeRefreshLayout = findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        final JsoupParser jsoupParser = new JsoupParser(presenter);
                        jsoupParser.execute();
                    }
                }, 1000);
            }
        });


        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_dark,
                android.R.color.holo_red_light);

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
        addTimeRecyclerViewAdapter = new AddTimeRecyclerViewAdapter(getApplicationContext(), list1, list2);
        timeRecyclerView.setAdapter(addTimeRecyclerViewAdapter);
    }
}

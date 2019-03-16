package com.a.clock.Views.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.a.clock.R;
import com.a.clock.Views.Adapters.FragmentAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    String POSITION = "position";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.mainactivity_view_pager);
        FragmentAdapter adapter = new FragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout = findViewById(R.id.mainactivity_tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onResume() {
        super.onResume();
        restorePosition();
    }

    @Override
    public void onPause() {
        super.onPause();
        savePosition();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        savePosition();
    }

    private void savePosition() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(POSITION, viewPager.getCurrentItem());
        editor.apply();
    }

    private void restorePosition() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        viewPager.setCurrentItem(sharedPreferences.getInt(POSITION, 0));
    }

}

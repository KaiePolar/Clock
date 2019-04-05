package com.a.clock.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.clock.AdditionalClasses.CountTimer;
import com.a.clock.Presenters.TimerPresenter;
import com.a.clock.R;

public class TimerFragment extends Fragment implements com.a.clock.Interfaces.View.TimerView {

    int hoursInt, minutesInt, secondsInt;
    private TimerPresenter presenter;
    private ImageView hoursUpImageView, minutesUpImageView, secondsUpImageView;
    private ImageView hoursDownImageView, minutesDownImageView, secondsDownImageView;
    private TextView hoursTextView, minutesTextView, secondsTextView;
    CountTimer timer;
    private String hours = "00", minutes = "00", seconds = "00";
    private Button resetButton;
    private FloatingActionButton startButton, pauseButton;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TimerPresenter();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter.bindView(this);
        final View view = inflater.inflate(R.layout.fragment_timer, container, false);
        hoursDownImageView = view.findViewById(R.id.hours_down_image_view);
        minutesDownImageView = view.findViewById(R.id.minutes_down_image_view);
        secondsDownImageView = view.findViewById(R.id.seconds_down_image_view);
        hoursUpImageView = view.findViewById(R.id.hours_up_image_view);
        minutesUpImageView = view.findViewById(R.id.minutes_up_image_view);
        secondsUpImageView = view.findViewById(R.id.seconds_up_image_view);
        hoursTextView = view.findViewById(R.id.hours_digits_text_view);
        minutesTextView = view.findViewById(R.id.minutes_digits_text_view);
        secondsTextView = view.findViewById(R.id.seconds_digits_text_view);
        startButton = view.findViewById(R.id.timer_start_button);
        pauseButton = view.findViewById(R.id.timer_pause_button);
        resetButton = view.findViewById(R.id.timer_reset_button);

        pauseButton.hide();
        startButton.show();

        hoursUpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoursInt = Integer.parseInt(hoursTextView.getText().toString());
                if (hoursInt != 99) {
                    ++hoursInt;
                }
                if (hoursInt < 10) {
                    hours = "0" + hoursInt;
                }
                if (hoursInt >= 10) {
                    hours = String.valueOf(hoursInt);
                }
                hoursTextView.setText(hours);
            }
        });
        minutesUpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minutesInt = Integer.parseInt(minutesTextView.getText().toString());
                if (minutesInt != 59) {
                    ++minutesInt;
                }
                if (minutesInt < 10) {
                    minutes = "0" + minutesInt;
                }
                if (minutesInt >= 10) {
                    minutes = String.valueOf(minutesInt);
                }
                minutesTextView.setText(minutes);
            }
        });
        secondsUpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondsInt = Integer.parseInt(secondsTextView.getText().toString());
                if (secondsInt != 59) {
                    ++secondsInt;
                }
                if (secondsInt < 10) {
                    seconds = "0" + secondsInt;
                }
                if (secondsInt >= 10) {
                    seconds = String.valueOf(secondsInt);
                }
                secondsTextView.setText(seconds);
            }
        });

        hoursDownImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hoursInt = Integer.parseInt(hoursTextView.getText().toString());
                if (hoursInt != 0) {
                    --hoursInt;
                }
                if (hoursInt < 10) {
                    hours = "0" + hoursInt;
                }
                if (hoursInt >= 10) {
                    hours = String.valueOf(hoursInt);
                }
                hoursTextView.setText(hours);
            }
        });
        minutesDownImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int minutesInt = Integer.parseInt(minutesTextView.getText().toString());
                if (minutesInt != 0) {
                    --minutesInt;
                }
                if (minutesInt < 10) {
                    minutes = "0" + minutesInt;
                }
                if (minutesInt >= 10) {
                    minutes = String.valueOf(minutesInt);
                }
                minutesTextView.setText(minutes);
            }
        });
        secondsDownImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int secondsInt = Integer.parseInt(secondsTextView.getText().toString());
                if (secondsInt != 0) {
                    --secondsInt;
                }
                if (secondsInt < 10) {
                    seconds = "0" + secondsInt;
                }
                if (secondsInt >= 10) {
                    seconds = String.valueOf(secondsInt);
                }
                secondsTextView.setText(seconds);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String secondsString = secondsTextView.getText().toString();
                long seconds = Long.parseLong(secondsString) * 1000;

                String minutesString = minutesTextView.getText().toString();
                long minutes = Long.parseLong(minutesString) * 60 * 1000;
                String hoursString = hoursTextView.getText().toString();
                long hours = Long.parseLong(hoursString) * 3600 * 1000;
                long time = seconds + minutes + hours;
                timer = new CountTimer(time, 1000, presenter, getContext());
                timer.start();
                switchStartPauseButtons();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();
                switchStartPauseButtons();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondsTextView.setText("00");
                secondsInt = 0;
                minutesTextView.setText("00");
                minutesInt = 0;
                hoursTextView.setText("00");
                hoursInt = 0;
            }
        });

        return view;
    }

    public void reduceSeconds() {
        if (secondsInt < 11) {
            secondsTextView.setText("0" + String.valueOf(--secondsInt));
        }
        if (secondsInt >= 11) {
            secondsTextView.setText(String.valueOf(--secondsInt));
        }
        if (secondsInt == -1 ) {
            secondsInt = 60;
            secondsTextView.setText(String.valueOf(--secondsInt));
            reduceMinutes();
        }

    }

    public void reduceMinutes() {
        if (minutesInt < 11) {
            minutesTextView.setText("0" + String.valueOf(--minutesInt));
        }
        if (minutesInt >= 11) {
            minutesTextView.setText(String.valueOf(--minutesInt));
        }
        if(minutesInt==-1&&hoursInt!=0){
            minutesInt = 60;
            minutesTextView.setText(String.valueOf(--minutesInt));
            reduceHours();
        }

    }

    public void reduceHours() {
        if (hoursInt < 10) {
            hoursTextView.setText("0" + String.valueOf(--hoursInt));
        }
        if (hoursInt >= 10) {
            hoursTextView.setText(String.valueOf(--hoursInt));
        }

    }

    public void switchStartPauseButtons(){
        if(startButton.isShown()){
            startButton.hide();
            pauseButton.show();
        }
        else if(pauseButton.isShown()){
            pauseButton.hide();
            startButton.show();
        }
    }
}

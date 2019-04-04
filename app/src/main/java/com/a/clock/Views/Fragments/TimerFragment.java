package com.a.clock.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.clock.Presenters.TimerPresenter;
import com.a.clock.R;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Repositories.TimeRepository.TimeItem;

import java.util.ArrayList;
import java.util.List;

public class TimerFragment extends Fragment implements com.a.clock.Interfaces.View {

    private Button timerButton;
    private TimerPresenter presenter;
    private ImageView hoursUpImageView, minutesUpImageView, secondsUpImageView;
    private ImageView hoursDownImageView, minutesDownImageView, secondsDownImageView;
    private TextView hoursTextView, minutesTextView, secondsTextView;
    private String hours = "00", minutes = "00", seconds = "00";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TimerPresenter();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter.bindView(this);
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        timerButton = view.findViewById(R.id.timer_start_button);
        hoursDownImageView = view.findViewById(R.id.hours_down_image_view);
        minutesDownImageView = view.findViewById(R.id.minutes_down_image_view);
        secondsDownImageView = view.findViewById(R.id.seconds_down_image_view);
        hoursUpImageView = view.findViewById(R.id.hours_up_image_view);
        minutesUpImageView = view.findViewById(R.id.minutes_up_image_view);
        secondsUpImageView = view.findViewById(R.id.seconds_up_image_view);
        hoursTextView = view.findViewById(R.id.hours_digits_text_view);
        minutesTextView = view.findViewById(R.id.minutes_digits_text_view);
        secondsTextView = view.findViewById(R.id.seconds_digits_text_view);

        hoursUpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hoursInt = Integer.parseInt(hoursTextView.getText().toString());
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
                int minutesInt = Integer.parseInt(minutesTextView.getText().toString());
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
                int secondsInt = Integer.parseInt(secondsTextView.getText().toString());
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

//        timerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                long time = ((Integer.parseInt(hoursTextView.getText().toString()))*360+(Long.parseLong(minutesTextView.getText().toString()))*60+(Long.parseLong(secondsTextView.toString()));
//                Toast.makeText(getContext(),String.valueOf(time),Toast.LENGTH_SHORT);
//                final CountDownTimer timer = new CountDownTimer(time,1000) {
//                    @Override
//                    public void onTick(long millisUntilFinished) {
//                        int secondsInt = Integer.parseInt(secondsTextView.getText().toString());
//                        if (secondsInt != 0) {
//                            --secondsInt;
//                        }
//                        if (secondsInt < 10) {
//                            seconds = "0" + secondsInt;
//                        }
//                        if (secondsInt >= 10) {
//                            seconds = String.valueOf(secondsInt);
//                        }
//                        secondsTextView.setText(seconds);
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                    }
//                };
//            }
//        });

        return view;
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

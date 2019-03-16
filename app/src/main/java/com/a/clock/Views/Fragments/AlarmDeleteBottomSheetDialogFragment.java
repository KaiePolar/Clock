package com.a.clock.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.a.clock.Presenters.AlarmPresenter;
import com.a.clock.R;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;

public class AlarmDeleteBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private Button deleteButton;
    private AlarmPresenter presenter;
    private AlarmItem alarmItem;


    public static AlarmDeleteBottomSheetDialogFragment newInstance() {

        return new AlarmDeleteBottomSheetDialogFragment();
    }

    public void setPresenter(AlarmPresenter presenter) {
        this.presenter = presenter;
    }


    public void setAlarmItem(AlarmItem alarmItem) {
        this.alarmItem = alarmItem;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.delete_bottom_sheet_dialog, container,
                false);


        deleteButton = view.findViewById(R.id.delete_button_dialog);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.hideDialog();
                presenter.deleteItem(alarmItem);
            }
        });


        return view;

    }
}


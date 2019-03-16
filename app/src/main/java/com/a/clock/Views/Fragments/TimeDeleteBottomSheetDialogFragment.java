package com.a.clock.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.a.clock.Presenters.TimePresenter;
import com.a.clock.R;
import com.a.clock.Repositories.TimeRepository.TimeItem;

public class TimeDeleteBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private Button deleteButton;
    private TimePresenter presenter;
    private TimeItem timeItem;


    public static TimeDeleteBottomSheetDialogFragment newInstance() {

        return new TimeDeleteBottomSheetDialogFragment();
    }

    public void setPresenter(TimePresenter presenter) {
        this.presenter = presenter;
    }


    public void setTimeItem(TimeItem timeItem) {
        this.timeItem = timeItem;
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
                Log.d("TAG", "clicked");
                presenter.hideDialog();
                presenter.deleteItem(timeItem);
            }
        });


        return view;

    }
}

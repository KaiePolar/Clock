package com.a.clock.Views.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.a.clock.AdditionalClasses.Alarm;
import com.a.clock.Presenters.AlarmPresenter;
import com.a.clock.R;
import com.a.clock.Repositories.AlarmRepository.AlarmItem;
import com.a.clock.Views.Fragments.AlarmDeleteBottomSheetDialogFragment;

import java.util.List;

public class AlarmRecyclerViewAdapter extends RecyclerView.Adapter<AlarmRecyclerViewAdapter.ViewHolder> {

    private List<AlarmItem> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private AlarmPresenter presenter;
    private Context context;
    private Alarm alarm;
    private AlarmDeleteBottomSheetDialogFragment alarmDeleteBottomSheetDialogFragment;


    public AlarmRecyclerViewAdapter(Context context, List<AlarmItem> data, AlarmPresenter presenter, AlarmDeleteBottomSheetDialogFragment alarmDeleteBottomSheetDialogFragment) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = data;
        this.presenter = presenter;
        this.alarmDeleteBottomSheetDialogFragment = alarmDeleteBottomSheetDialogFragment;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.alarm_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String alarmItemTime = String.valueOf(mData.get(position).time);
        final int hour = Integer.parseInt(alarmItemTime.substring(0, alarmItemTime.indexOf(':')));
        final int minute = Integer.parseInt(alarmItemTime.substring(alarmItemTime.indexOf(':') + 1));

        boolean alarmItemEnabled = mData.get(position).enabled;
        final int id = mData.get(position).id;

        holder.mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean switchEnabled = holder.mySwitch.isChecked();
                presenter.updateItem(switchEnabled, id);
                if (switchEnabled) {
                    Toast.makeText(context, hour + " " + minute, Toast.LENGTH_SHORT).show();
                    alarm = new Alarm(String.valueOf(hour), String.valueOf(minute), context, mData.get(position).id);
                } else {
                    Toast.makeText(context, hour + " " + minute, Toast.LENGTH_SHORT).show();
                    if (!(alarm == null)) {
                        alarm.cancelAlarm();
                    }
                }


            }
        });
        holder.myTextView.setText(alarmItemTime);
        holder.mySwitch.setChecked(alarmItemEnabled);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public AlarmItem getItem(int id) {
        return mData.get(id);
    }


    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        Switch mySwitch;

        ViewHolder(final View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.alarm_item_text_view);
            mySwitch = itemView.findViewById(R.id.alarm_item_switch);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    presenter.showDeleteDialog();
                    alarmDeleteBottomSheetDialogFragment.setAlarmItem(getItem(getAdapterPosition()));
                    return false;
                }
            });
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}

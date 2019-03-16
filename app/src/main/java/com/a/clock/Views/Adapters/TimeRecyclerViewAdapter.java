package com.a.clock.Views.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a.clock.Presenters.TimePresenter;
import com.a.clock.R;
import com.a.clock.Repositories.TimeRepository.TimeItem;
import com.a.clock.Views.Fragments.TimeDeleteBottomSheetDialogFragment;

import java.util.List;

public class TimeRecyclerViewAdapter extends RecyclerView.Adapter<TimeRecyclerViewAdapter.ViewHolder> {

    private List<TimeItem> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private TimePresenter presenter;
    private TextView cityNameTextView;
    private TextView cityTimeTextView;
    private TimeDeleteBottomSheetDialogFragment timeDeleteBottomSheetDialogFragment;


    public TimeRecyclerViewAdapter(Context context, List<TimeItem> data, TimePresenter presenter, TimeDeleteBottomSheetDialogFragment timeDeleteBottomSheetDialogFragment) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.presenter = presenter;
        this.timeDeleteBottomSheetDialogFragment = timeDeleteBottomSheetDialogFragment;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.time_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.cityNameTextView.setText(mData.get(position).cityname);
        holder.cityTimeTextView.setText((mData.get(position).citytime));
        Log.d("TAG", "inserted " + mData.get(position).cityname);

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public TimeItem getItem(int id) {
        return mData.get(id);
    }


    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView cityNameTextView;
        TextView cityTimeTextView;


        ViewHolder(final View itemView) {
            super(itemView);
            cityNameTextView = itemView.findViewById(R.id.time_item_text_view1);
            cityTimeTextView = itemView.findViewById(R.id.time_item_text_view2);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    presenter.showDeleteDialog();

                    timeDeleteBottomSheetDialogFragment.setTimeItem(getItem(getAdapterPosition()));
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

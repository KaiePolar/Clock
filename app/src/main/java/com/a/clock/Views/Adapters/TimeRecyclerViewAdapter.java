package com.a.clock.Views.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a.clock.Presenters.AlarmPresenter;
import com.a.clock.R;

import java.util.ArrayList;

public class TimeRecyclerViewAdapter extends RecyclerView.Adapter<TimeRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> namesList;
    private ArrayList<String> timesList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private AlarmPresenter presenter;


    public TimeRecyclerViewAdapter(Context context, ArrayList<String> data,ArrayList<String> data2) {
        this.mInflater = LayoutInflater.from(context);
        this.namesList = data;
        this.timesList = data2;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.time_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.myTextView.setText(namesList.get(position));
        holder.myTextView2.setText(timesList.get(position));

            }



    @Override
    public int getItemCount() {
        return namesList.size();
    }


    public String getItem(int id) {
        return namesList.get(id);
    }


    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        TextView myTextView2;

        ViewHolder(final View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.time_item_text_view1);
            myTextView2 = itemView.findViewById(R.id.time_item_text_view2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}

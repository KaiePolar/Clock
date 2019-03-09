package com.a.clock.Views.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a.clock.Presenters.AddTimePresenter;
import com.a.clock.R;
import com.a.clock.Views.Activities.MainActivity;

import java.util.ArrayList;

public class AddTimeRecyclerViewAdapter extends RecyclerView.Adapter<AddTimeRecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> namesList;
    private ArrayList<String> timesList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private AddTimePresenter presenter;
    private Context context;


    public AddTimeRecyclerViewAdapter(Context context, ArrayList<String> data, ArrayList<String> data2) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.namesList = data;
        this.timesList = data2;
        presenter = new AddTimePresenter(context);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.time_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.cityNameTextView.setText(namesList.get(position));
        holder.cityTimeTextView.setText(timesList.get(position));

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
        TextView cityNameTextView;
        TextView cityTimeTextView;

        ViewHolder(final View itemView) {
            super(itemView);
            cityNameTextView = itemView.findViewById(R.id.time_item_text_view1);
            cityTimeTextView = itemView.findViewById(R.id.time_item_text_view2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            presenter.addItem(cityNameTextView.getText().toString(), cityTimeTextView.getText().toString());
            Intent intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);


        }
    }
}

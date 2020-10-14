package com.example.tenmindemoapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tenmindemoapp.pojo.Data;
import com.example.tenmindemoapp.R;

import java.util.ArrayList;

public class AdapterFroSubList extends RecyclerView.Adapter<AdapterFroSubList.ViewHolder>  {

    private ArrayList<Data> dataList;

    public AdapterFroSubList(ArrayList<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFroSubList.ViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.itemNameTV.setText(data.getItemName());
        holder.itemIconIV.setImageResource(data.getIcon_address());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTV;
        ImageView itemIconIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTV = itemView.findViewById(R.id.itemNameTV);
            itemIconIV = itemView.findViewById(R.id.itemIconIV);
        }
    }
}
